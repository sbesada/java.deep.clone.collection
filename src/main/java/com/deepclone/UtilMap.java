package com.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class UtilMap {

    /**
     * 
     * clone
     * 
     * @param map
     * @return
     */
    protected static <K, V> Map<K, V> clone(final Map<K, V> map) {

        if (map == null) {
            return null;
        }

        Map<K, V> result = null;

        final TypeCloneResult typeCloneResult = typeClone(map);

        switch (typeCloneResult.getTypeClone()) {

        case HashMap:

            result = deepCloneHashMap((HashMap<K, V>) map);

            break;
        case TreeMap:
            result = deepCloneTreeMap((TreeMap<K, V>) map);
            break;

        case LinkedHashMap:
            result = deepCloneLinkedHashMap((LinkedHashMap<K, V>) map);
            break;

        case EnumMap:
            result = deepCloneEnumMap((EnumMap) map);
            break;

        case WeakHashMap:
            result = deepCloneWeakHashMap((WeakHashMap<K, V>) map);

            break;

        case IdentityHashMap:
            result = deepCloneIdentityHashMap((IdentityHashMap<K, V>) map);

            break;

        default:
            return result = null;

        }

        return result;

    }

    /**
     * 
     * deepCloneMap
     * 
     * 
     * @param map
     * @return
     */
    private static <K, V, T> Map<K, V> deepCloneHashMap(final HashMap<K, V> map) {

        if (map == null) {
            return null;
        }

        Map<K, V> result = new HashMap<K, V>();

        final TypeCloneResult typeCloneResult = typeCloneMapNextElement(map);
        final Method method = typeCloneResult.getMethod();

        for (final Map.Entry<K, V> entry : map.entrySet()) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.put(entry.getKey(), (V) method.invoke(entry.getValue()));
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            case Collection:
                result.put(entry.getKey(), (V) UtilCollection.clone((Collection<T>) entry.getValue()));

                break;

            case Map:
                result.put(entry.getKey(), (V) clone((Map<K, V>) entry.getValue()));

                break;

            default:
                return result = (Map<K, V>) map.clone();

            }

        }

        return result;

    }

    /**
     * 
     * deepCloneMap
     * 
     * 
     * @param map
     * @return
     */
    private static <K, V, T> Map<K, V> deepCloneTreeMap(final TreeMap<K, V> map) {

        if (map == null) {
            return null;
        }

        Map<K, V> result = new TreeMap<K, V>();

        final TypeCloneResult typeCloneResult = typeCloneMapNextElement(map);
        final Method method = typeCloneResult.getMethod();

        for (final Map.Entry<K, V> entry : map.entrySet()) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.put(entry.getKey(), (V) method.invoke(entry.getValue()));
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            case Collection:
                result.put(entry.getKey(), (V) UtilCollection.clone((Collection<T>) entry.getValue()));

                break;

            case Map:
                result.put(entry.getKey(), (V) clone((Map<K, V>) entry.getValue()));

                break;

            default:
                return result = (Map<K, V>) map.clone();

            }

        }

        return result;

    }

    /**
     * 
     * deepCloneMap
     * 
     * 
     * @param map
     * @return
     */
    private static <K, V, T> Map<K, V> deepCloneLinkedHashMap(final LinkedHashMap<K, V> map) {

        if (map == null) {
            return null;
        }

        Map<K, V> result = new LinkedHashMap<K, V>();

        final TypeCloneResult typeCloneResult = typeCloneMapNextElement(map);
        final Method method = typeCloneResult.getMethod();

        for (final Map.Entry<K, V> entry : map.entrySet()) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.put(entry.getKey(), (V) method.invoke(entry.getValue()));
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            case Collection:
                result.put(entry.getKey(), (V) UtilCollection.clone((Collection<T>) entry.getValue()));

                break;

            case Map:
                result.put(entry.getKey(), (V) clone((Map<K, V>) entry.getValue()));

                break;

            default:
                return result = (Map<K, V>) map.clone();

            }

        }

        return result;

    }

    /**
     * 
     * deepCloneMap
     * 
     * @param <T>
     * 
     * @param map
     * @return
     */
    private static <K, V, T> Map<K, V> deepCloneEnumMap(final EnumMap map) {

        if (map == null) {
            return null;
        }

        final TypeCloneResult typeCloneResult = typeCloneEnumMapNextElement(map);
        final Method method = typeCloneResult.getMethod();

        Map<K, V> result = new EnumMap(typeCloneResult.getElement());

        final Iterator enumKeySet = map.keySet().iterator();

        while (enumKeySet.hasNext()) {

            final Object key = enumKeySet.next();

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.put((K) key, (V) method.invoke(map.get(key)));
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            case Collection:
                result.put((K) key, (V) UtilCollection.clone((Collection<T>) map.get(key)));

                break;

            case Map:
                result.put((K) key, (V) clone((Map<K, V>) map.get(key)));

                break;

            default:
                return result = map.clone();

            }
        }

        return result;

    }

    /**
     * 
     * deepCloneMap
     * 
     * 
     * @param map
     * @return
     */
    private static <K, V, T> Map<K, V> deepCloneWeakHashMap(final WeakHashMap<K, V> map) {

        if (map == null) {
            return null;
        }

        final Map<K, V> result = new WeakHashMap<K, V>();

        final TypeCloneResult typeCloneResult = typeCloneMapNextElement(map);
        final Method method = typeCloneResult.getMethod();

        for (final Map.Entry<K, V> entry : map.entrySet()) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.put(entry.getKey(), (V) method.invoke(entry.getValue()));
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            case Collection:
                result.put(entry.getKey(), (V) UtilCollection.clone((Collection<T>) entry.getValue()));

                break;

            case Map:
                result.put(entry.getKey(), (V) clone((Map<K, V>) entry.getValue()));

                break;

            default:
                result.put(entry.getKey(), (V) clone((Map<K, V>) entry.getValue()));

            }

        }

        return result;

    }

    /**
     * 
     * deepCloneMap
     * 
     * @param map
     * @return
     */
    public static <K, V, T> Map<K, V> deepCloneIdentityHashMap(final IdentityHashMap<K, V> map) {

        if (map == null) {
            return null;
        }

        Map<K, V> result = new IdentityHashMap<K, V>();

        final TypeCloneResult typeCloneResult = typeCloneMapNextElement(map);
        final Method method = typeCloneResult.getMethod();

        for (final Map.Entry<K, V> entry : map.entrySet()) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.put(entry.getKey(), (V) method.invoke(entry.getValue()));
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            case Collection:
                result.put(entry.getKey(), (V) UtilCollection.clone((Collection<T>) entry.getValue()));

                break;

            case Map:
                result.put(entry.getKey(), (V) clone((Map<K, V>) entry.getValue()));

                break;

            default:
                return result = (Map<K, V>) map.clone();

            }

        }

        return result;

    }

    /**************************************************************************/

    /**
     * 
     * typeCloneMap
     * 
     * @param element
     * @return
     */
    private static <V, K> TypeCloneResult typeClone(final Map<K, V> element) {

        final TypeCloneResult result = new TypeCloneResult();

        final Class clazz = element.getClass();

        if (HashMap.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.HashMap);
        } else if (TreeMap.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.TreeMap);
        } else if (LinkedHashMap.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.LinkedHashMap);
        } else if (EnumMap.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.EnumMap);
        } else if (WeakHashMap.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.WeakHashMap);
        } else if (IdentityHashMap.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.IdentityHashMap);

        } else {
            result.setTypeClone(TypeClone.NotCloneClass);
        }
        return result;

    }

    /**
     * 
     * typeCloneMapNextElement
     * 
     * @param map
     * @return
     */
    private static <V, K> TypeCloneResult typeCloneMapNextElement(final Map<K, V> map) {

        final TypeCloneResult result = new TypeCloneResult();

        for (final Map.Entry<K, V> entry : map.entrySet()) {
            final Class clazz = entry.getValue().getClass();

            if (Map.class.isAssignableFrom(clazz)) {
                result.setTypeClone(TypeClone.Map);
            } else if (Collection.class.isAssignableFrom(clazz)) {
                result.setTypeClone(TypeClone.Collection);
            } else if (Cloneable.class.isAssignableFrom(clazz)) {
                try {
                    result.setTypeClone(TypeClone.CloneClass);
                    result.setMethod(clazz.getDeclaredMethod("clone"));
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else {
                result.setTypeClone(TypeClone.NotCloneClass);
            }

            break;
        }

        return result;

    }

    /**
     * 
     * typeCloneEnumMapNextElement
     * 
     * @param map
     * @return
     */
    private static <V, K> TypeCloneResult typeCloneEnumMapNextElement(final Map<K, V> map) {

        final TypeCloneResult result = new TypeCloneResult();

        for (final Map.Entry<K, V> entry : map.entrySet()) {
            final Class clazz = entry.getValue().getClass();
            result.setElement(entry.getKey().getClass());

            if (Map.class.isAssignableFrom(clazz)) {
                result.setTypeClone(TypeClone.Map);
            } else if (Collection.class.isAssignableFrom(clazz)) {
                result.setTypeClone(TypeClone.Collection);
            } else if (Cloneable.class.isAssignableFrom(clazz)) {
                try {
                    result.setTypeClone(TypeClone.CloneClass);
                    result.setMethod(clazz.getDeclaredMethod("clone"));
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else {
                result.setTypeClone(TypeClone.NotCloneClass);
            }

            break;
        }

        return result;

    }

}
