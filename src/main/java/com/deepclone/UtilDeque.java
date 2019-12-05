package com.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * 
 * @author Sergio Besada
 * 
 */
public class UtilDeque {

    /**
     * 
     * deepCloneDeque
     * 
     * @param deque
     * @return
     */
    protected static <T, V, K> Deque<T> deepCloneArrayDeque(final ArrayDeque<T> deque) {

        if (deque == null) {
            return null;
        }

        final Deque<T> result = new ArrayDeque<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(deque);
        final Method method = typeCloneResult.getMethod();
        for (final T t : deque) {

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
                result.add(t);
            }

        }

        return result;
    }

    /**
     * 
     * cloneDeepDeque
     * 
     * @param deque
     * @return
     */
    protected static <T, V, K> Deque<T> deepCloneLinkedBlockingDeque(final LinkedBlockingDeque<T> deque) {

        if (deque == null) {
            return null;
        }

        final Deque<T> result = new LinkedBlockingDeque<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(deque);
        final Method method = typeCloneResult.getMethod();
        for (final T t : deque) {

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
                result.add(t);
            }

        }

        return result;
    }

    /***********************************************************************/

    /**
     * 
     * typeCloneListNextElement
     * 
     * @param <V>
     * 
     * @param list
     * @return
     */
    private static <V> TypeCloneResult typeCloneListNextElement(final Deque<V> deque) {

        final TypeCloneResult result = new TypeCloneResult();

        if (deque.isEmpty()) {
            return result;
        }

        final Class clazz = deque.peek().getClass();

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
