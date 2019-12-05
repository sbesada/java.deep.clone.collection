package com.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 
 * 
 * @author Sergio Besada
 * 
 */
public class UtilSet {

    /********************** clone methods: Set ************************/

    /**
     * 
     * deepCloneSet
     * 
     * @param set
     * @return
     */
    protected static <T, V, K> Set<T> deepCloneHashSet(final HashSet<T> set) {

        if (set == null) {
            return null;
        }

        Set<T> result = new HashSet<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(set);
        final Method method = typeCloneResult.getMethod();
        for (final T t : set) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.add((T) method.invoke(t));
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;

            case Collection:
                result.add((T) UtilCollection.clone((Collection<T>) t));

                break;

            case Map:
                result.add((T) UtilMap.clone((Map<K, V>) t));

                break;

            default:
                return result = (Set<T>) set.clone();

            }

        }

        return result;
    }

    /**
     * 
     * deepCloneSet
     * 
     * @param set
     * @return
     */
    protected static <T, V, K> Set<T> deepCloneTreeSet(final TreeSet<T> set) {

        if (set == null) {
            return null;
        }

        Set<T> result = new TreeSet<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(set);
        final Method method = typeCloneResult.getMethod();
        for (final T t : set) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.add((T) method.invoke(t));
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;

            case Collection:
                result.add((T) UtilCollection.clone((Collection<T>) t));

                break;

            case Map:
                result.add((T) UtilMap.clone((Map<K, V>) t));

                break;

            default:
                return result = (Set<T>) set.clone();

            }

        }

        return result;
    }

    /**
     * 
     * deepCloneSet
     * 
     * @param set
     * @return
     */
    protected static <T, V, K> Set<T> deepCloneLinkedHashSet(final LinkedHashSet<T> set) {

        if (set == null) {
            return null;
        }

        Set<T> result = new LinkedHashSet<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(set);
        final Method method = typeCloneResult.getMethod();
        for (final T t : set) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.add((T) method.invoke(t));
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;

            case Collection:
                result.add((T) UtilCollection.clone((Collection<T>) t));

                break;

            case Map:
                result.add((T) UtilMap.clone((Map<K, V>) t));

                break;

            default:
                return result = (Set<T>) set.clone();

            }

        }

        return result;
    }

    /**
     * 
     * deepCloneEnumSet
     * 
     * @param set
     * @return
     */
    protected static <T> Set<T> deepCloneEnumSet(final EnumSet set) {

        if (set == null) {
            return null;
        }

        return set.clone();

    }

    /**
     * 
     * deepCloneSet
     * 
     * @param set
     * @return
     */
    protected static <T, V, K> Set<T> deepCloneCopyOnWriteArraySet(final CopyOnWriteArraySet<T> set) {

        if (set == null) {
            return null;
        }

        final Set<T> result = new CopyOnWriteArraySet<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(set);
        final Method method = typeCloneResult.getMethod();
        for (final T t : set) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.add((T) method.invoke(t));
                } catch (final SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;

            case Collection:
                result.add((T) UtilCollection.clone((Collection<T>) t));

                break;

            case Map:
                result.add((T) UtilMap.clone((Map<K, V>) t));

                break;

            default:
                // return result = (Set<T>) set.clone(); Clone does not exists!!
                return set;

            }

        }

        return result;
    }

    /********************* end clone set **********************************/

    /**
     * 
     * typeCloneListNextElement
     * 
     * @param <V>
     * 
     * @param set
     * @return
     */
    private static <V> TypeCloneResult typeCloneListNextElement(final Set<V> set) {

        final TypeCloneResult result = new TypeCloneResult();
        Class clazz = null;
        for (final V element : set) {
            clazz = element.getClass();
            break;
        }

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
        return result;

    }

}
