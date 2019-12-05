package com.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * 
 * @author Sergio Besada
 * 
 */
public class UtilList {

    /**
     * 
     * deepCloneList
     * 
     * 
     * @param list
     * @return
     */
    protected static <T, V, K> List<T> deepCloneArrayList(final ArrayList<T> list) {

        if (list == null) {
            return null;
        }

        List<T> result = new ArrayList<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(list);
        final Method method = typeCloneResult.getMethod();

        for (final T t : list) {

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
                return result = (List<T>) list.clone();

            }

        }

        return result;
    }

    /**
     * 
     * cloneDeepList
     * 
     * @param list
     * @return
     */
    protected static <T, V, K> List<T> deepCloneLinkedList(final LinkedList<T> list) {

        if (list == null) {
            return null;
        }

        List<T> result = new LinkedList<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(list);
        final Method method = typeCloneResult.getMethod();
        for (final T t : list) {

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
                return result = (List<T>) list.clone();

            }

        }

        return result;
    }

    /**
     * 
     * deepCloneList
     * 
     * @param list
     * @return
     */
    protected static <T, V, K> List<T> deepCloneCopyOnWriteArrayList(final CopyOnWriteArrayList<T> list) {

        if (list == null) {
            return null;
        }

        List<T> result = new CopyOnWriteArrayList<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(list);
        final Method method = typeCloneResult.getMethod();
        for (final T t : list) {

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
                return result = (List<T>) list.clone();

            }

        }

        return result;
    }

    /***********************************************************************/

    /**
     * 
     * typeCloneListNextElement
     * 
     * @param list
     * @return
     */
    protected static <V> TypeCloneResult typeCloneListNextElement(final List<V> list) {

        final TypeCloneResult result = new TypeCloneResult();

        if (list.isEmpty()) {
            return result;
        }

        final Class clazz = list.get(0).getClass();

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
