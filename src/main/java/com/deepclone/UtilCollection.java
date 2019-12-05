package com.deepclone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 
 * 
 * @author sergio Besada
 * 
 */
public class UtilCollection {

    /**
     * 
     * clone
     * 
     * @param colecction
     * @return
     */
    protected static <T, V, K> Collection<T> clone(final Collection<T> colecction) {

        if (colecction == null) {
            return null;
        }

        Collection<T> result;

        final TypeCloneResult typeCloneResult = typeClone(colecction);

        switch (typeCloneResult.getTypeClone()) {

        case List:
            result = deepCloneList((List<T>) colecction);
            break;

        case Set:
            result = deepCloneSet((Set<T>) colecction);
            break;

        case Queue:
            result = deepCloneQueue((Queue<T>) colecction);
            break;

        case Deque:
            result = deepCloneDeque((Deque<T>) colecction);
            break;

        default:
            result = null;
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
    public static <T, V, K> Collection<T> deepCloneList(final List<T> list) {

        if (list == null) {
            return null;
        }

        final TypeCloneResult typeCloneResult = typeCloneList(list);

        Collection<T> result;

        switch (typeCloneResult.getTypeClone()) {

        case ArrayList:
            result = UtilList.deepCloneArrayList((ArrayList<T>) list);
            break;

        case LinkedList:
            result = UtilList.deepCloneLinkedList((LinkedList<T>) list);
            break;

        case CopyOnWriteArrayList:
            result = UtilList.deepCloneCopyOnWriteArrayList((CopyOnWriteArrayList<T>) list);
            break;

        default:
            result = null;
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
    public static <T, V, K> Collection<T> deepCloneSet(final Set<T> set) {

        if (set == null) {
            return null;
        }

        final TypeCloneResult typeCloneResult = typeCloneSet(set);

        Collection<T> result;

        switch (typeCloneResult.getTypeClone()) {

        case HashSet:
            result = UtilSet.deepCloneHashSet((HashSet) set);
            break;

        case TreeSet:
            result = UtilSet.deepCloneTreeSet((TreeSet) set);
            break;

        case LinkedHashSet:
            result = UtilSet.deepCloneLinkedHashSet((LinkedHashSet) set);
            break;

        case EnumSet:
            result = UtilSet.deepCloneEnumSet((EnumSet) set);
            break;

        case CopyOnWriteArraySet:
            result = UtilSet.deepCloneCopyOnWriteArraySet((CopyOnWriteArraySet) set);
            break;

        default:
            result = null;
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
    public static <T, V, K> Collection<T> deepCloneQueue(final Queue<T> queue) {

        if (queue == null) {
            return null;
        }

        final TypeCloneResult typeCloneResult = typeCloneQueue(queue);

        Collection<T> result;

        switch (typeCloneResult.getTypeClone()) {

        case PriorityQueue:
            result = UtilQueue.deepClonePriorityQueue((PriorityQueue<T>) queue);
            break;

        case LinkedBlockingQueue:
            result = UtilQueue.deepCloneLinkedBlockingQueue((LinkedBlockingQueue<T>) queue);
            break;

        case ArrayBlockingQueue:
            result = UtilQueue.deepCloneArrayBlockingQueue((ArrayBlockingQueue<T>) queue);
            break;

        case PriorityBlockingQueue:
            result = UtilQueue.deepClonePriorityBlockingQueue((PriorityBlockingQueue<T>) queue);
            break;

        case DelayQueue:
            result = (Collection<T>) UtilQueue.deepCloneDelayQueue((DelayQueue<Delayed>) queue);
            break;

        case SynchronousQueue:
            result = queue;
            break;

        default:
            result = null;
        }

        return result;
    }

    /**
     * 
     * deepCloneDeque
     * 
     * @param deque
     * @return
     */
    public static <T, V, K> Collection<T> deepCloneDeque(final Deque<T> deque) {

        if (deque == null) {
            return null;
        }

        final TypeCloneResult typeCloneResult = typeCloneDeque(deque);

        Collection<T> result;

        switch (typeCloneResult.getTypeClone()) {

        case ArrayDeque:
            result = UtilDeque.deepCloneArrayDeque((ArrayDeque<T>) deque);
            break;

        case LinkedBlockingDeque:
            result = UtilDeque.deepCloneLinkedBlockingDeque((LinkedBlockingDeque<T>) deque);
            break;

        default:
            result = null;
        }

        return result;
    }

    /********************************************************************/

    /**
     * 
     * typeClone
     * 
     * @param element
     * @return
     */
    public static <V, K, T> TypeCloneResult typeClone(final Collection<V> element) {

        final TypeCloneResult result = new TypeCloneResult();

        final Class clazz = element.getClass();

        if (List.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.List);
        } else if (Set.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.Set);
        } else if (Queue.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.Queue);
        } else if (Deque.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.Deque);
        } else {
            result.setTypeClone(TypeClone.NotCloneClass);
        }
        return result;

    }

    /**
     * 
     * typeClone
     * 
     * @param element
     * @return
     */
    public static <V, K, T> TypeCloneResult typeCloneList(final List<V> element) {

        final TypeCloneResult result = new TypeCloneResult();

        final Class clazz = element.getClass();

        if (ArrayList.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.ArrayList);
        } else if (LinkedList.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.LinkedList);
        } else if (CopyOnWriteArrayList.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.CopyOnWriteArrayList);

        } else {
            result.setTypeClone(TypeClone.NotCloneClass);
        }
        return result;

    }

    /**
     * 
     * typeClone
     * 
     * @param element
     * @return
     */
    public static <V, K, T> TypeCloneResult typeCloneSet(final Set<V> element) {

        final TypeCloneResult result = new TypeCloneResult();

        final Class clazz = element.getClass();

        if (HashSet.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.HashSet);
        } else if (TreeSet.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.TreeSet);
        } else if (LinkedHashSet.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.LinkedHashSet);
        } else if (EnumSet.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.EnumSet);
        } else if (CopyOnWriteArraySet.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.CopyOnWriteArraySet);
        } else {
            result.setTypeClone(TypeClone.NotCloneClass);
        }
        return result;

    }

    /**
     * 
     * typeClone
     * 
     * @param element
     * @return
     */
    public static <V, K, T> TypeCloneResult typeCloneQueue(final Queue<V> element) {

        final TypeCloneResult result = new TypeCloneResult();

        final Class clazz = element.getClass();

        if (PriorityQueue.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.PriorityQueue);
        } else if (LinkedBlockingQueue.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.LinkedBlockingQueue);
        } else if (ArrayBlockingQueue.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.ArrayBlockingQueue);
        } else if (PriorityBlockingQueue.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.PriorityBlockingQueue);
        } else if (DelayQueue.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.DelayQueue);
        } else if (SynchronousQueue.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.SynchronousQueue);
        } else {
            result.setTypeClone(TypeClone.NotCloneClass);
        }
        return result;

    }

    /**
     * 
     * typeClone
     * 
     * @param element
     * @return
     */
    public static <V, K, T> TypeCloneResult typeCloneDeque(final Deque<V> element) {

        final TypeCloneResult result = new TypeCloneResult();

        final Class clazz = element.getClass();

        if (ArrayDeque.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.ArrayDeque);
        } else if (LinkedBlockingDeque.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.LinkedBlockingDeque);
        } else {
            result.setTypeClone(TypeClone.NotCloneClass);
        }
        return result;
    }

}
