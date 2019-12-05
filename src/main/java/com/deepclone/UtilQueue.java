package com.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class UtilQueue {

    /**
     * 
     * deepCloneQueue
     * 
     * @param queue
     * @return
     */
    protected static <T, V, K> Queue<T> deepClonePriorityQueue(final PriorityQueue<T> queue) {

        if (queue == null) {
            return null;
        }

        final Queue<T> result = new PriorityQueue<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(queue);
        final Method method = typeCloneResult.getMethod();
        for (final T t : queue) {

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
     * deepCloneQueue
     * 
     * @param queue
     * @return
     */
    protected static <T, V, K> Queue<T> deepCloneLinkedBlockingQueue(final LinkedBlockingQueue<T> queue) {

        if (queue == null) {
            return null;
        }

        final Queue<T> result = new LinkedBlockingQueue<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(queue);
        final Method method = typeCloneResult.getMethod();
        for (final T t : queue) {

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
     * deepCloneQueue
     * 
     * @param queue
     * @return
     */
    protected static <T, V, K> Queue<T> deepCloneArrayBlockingQueue(final ArrayBlockingQueue<T> queue) {

        if (queue == null) {
            return null;
        }

        final Queue<T> result = new ArrayBlockingQueue<T>(queue.size());

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(queue);
        final Method method = typeCloneResult.getMethod();
        for (final T t : queue) {

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
     * deepCloneQueue
     * 
     * @param queue
     * @return
     */
    protected static <T, V, K> Queue<T> deepClonePriorityBlockingQueue(final PriorityBlockingQueue<T> queue) {

        if (queue == null) {
            return null;
        }

        final Queue<T> result = new PriorityBlockingQueue<T>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(queue);
        final Method method = typeCloneResult.getMethod();
        for (final T t : queue) {

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
     * deepCloneQueue
     * 
     * @param queue
     * @return
     */
    protected static <T, V, K> Queue<Delayed> deepCloneDelayQueue(final DelayQueue<Delayed> queue) {

        if (queue == null) {
            return null;
        }

        final Queue<Delayed> result = new DelayQueue<Delayed>();

        final TypeCloneResult typeCloneResult = typeCloneListNextElement(queue);
        final Method method = typeCloneResult.getMethod();
        for (final Delayed t : queue) {

            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                try {
                    result.add((Delayed) method.invoke(t));
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
                result.add((Delayed) UtilCollection.clone((Collection<T>) t));

                break;

            case Map:
                result.add((Delayed) UtilMap.clone((Map<K, V>) t));

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
    private static <V> TypeCloneResult typeCloneListNextElement(final Queue<V> queue) {

        final TypeCloneResult result = new TypeCloneResult();

        if (queue.isEmpty()) {
            return result;
        }

        final Class clazz = queue.peek().getClass();

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
