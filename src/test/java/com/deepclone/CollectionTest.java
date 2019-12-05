package com.deepclone;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.Test;

import com.deepclone.examples.DelayObject;
import com.deepclone.examples.ExampleClass;
import com.deepclone.examples.Size;

public class CollectionTest {
    public static int CONT = 1000;

    @Test
    public void Test_Collection() {

        /**************************************/
        /************** LIST ******************/
        /**************************************/

        List<ExampleClass> resultList = null;

        final List<ExampleClass> list = new ArrayList();
        for (int i = 0; i < CONT; i++) {
            list.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultList = DeepClone.clone(list);

        /********************/

        final List<ExampleClass> list2 = new LinkedList();
        for (int i = 0; i < CONT; i++) {
            list.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultList = DeepClone.clone(list2);

        /************************/

        final List<ExampleClass> list3 = new CopyOnWriteArrayList();
        for (int i = 0; i < CONT; i++) {
            list.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultList = DeepClone.clone(list3);

        /*************************************/
        /************* SET *****************/
        /*************************************/

        Set<ExampleClass> resultSet = null;

        final Set<ExampleClass> set1 = new HashSet<ExampleClass>();

        for (int i = 0; i < CONT; i++) {
            set1.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultSet = DeepClone.clone(set1);

        /******************************/

        final Set<ExampleClass> set2 = new TreeSet<ExampleClass>();

        for (int i = 0; i < CONT; i++) {
            set2.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultSet = DeepClone.clone(set2);

        /******************************/

        final Set<ExampleClass> set3 = new LinkedHashSet<ExampleClass>();

        for (int i = 0; i < CONT; i++) {
            set3.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultSet = DeepClone.clone(set3);

        /******************************/

        final Set<Size> set4 = EnumSet.of(Size.XL, Size.XXL, Size.XXXL);

        final Set<Size> result = DeepClone.clone(set4);

        /******************************/

        final Set<ExampleClass> set5 = new CopyOnWriteArraySet<ExampleClass>();

        for (int i = 0; i < CONT; i++) {
            set5.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultSet = DeepClone.clone(set5);

        /****************************************/
        /***************** QUEUE ****************/
        /****************************************/

        Queue<ExampleClass> resultQueue = null;

        final Queue<ExampleClass> queue = new PriorityQueue();
        for (int i = 0; i < CONT; i++) {
            queue.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultQueue = DeepClone.clone(queue);

        /*********************************/

        final Queue<ExampleClass> queue2 = new LinkedBlockingQueue();
        for (int i = 0; i < CONT; i++) {
            queue2.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultQueue = DeepClone.clone(queue2);

        /*********************************/

        final Queue<ExampleClass> queue3 = new ArrayBlockingQueue(CONT);
        for (int i = 0; i < CONT; i++) {
            queue3.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultQueue = DeepClone.clone(queue3);

        /*********************************/

        final Queue<ExampleClass> queue4 = new PriorityBlockingQueue(CONT);
        for (int i = 0; i < CONT; i++) {
            queue4.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultQueue = DeepClone.clone(queue4);

        /*********************************/

        final Queue<DelayObject> queue5 = new DelayQueue();
        for (int i = 0; i < CONT; i++) {
            queue5.add(new DelayObject("test" + i, 10));
        }

        final Queue<DelayObject> resultDelayQueue = DeepClone.clone(queue5);

        /****************************************/
        /**************** DEQUE *****************/
        /****************************************/

        Deque<ExampleClass> resultDeque = null;

        final Deque<ExampleClass> deque1 = new ArrayDeque();
        for (int i = 0; i < CONT; i++) {
            deque1.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultDeque = DeepClone.clone(deque1);

        /*********************************/

        final Deque<ExampleClass> deque2 = new LinkedBlockingDeque();
        for (int i = 0; i < CONT; i++) {
            deque2.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultDeque = DeepClone.clone(deque2);

        /**************************************/
        /****************** MAP ***************/
        /**************************************/

        Map<Integer, ExampleClass> resultMap = null;

        final Map<Integer, ExampleClass> map1 = new HashMap();
        for (int i = 0; i < CONT; i++) {
            map1.put(i, new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultMap = DeepClone.clone(map1);

        /*********************************/

        final Map<Integer, ExampleClass> map2 = new TreeMap();
        for (int i = 0; i < CONT; i++) {
            map2.put(i, new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultMap = DeepClone.clone(map2);

        /*********************************/

        final Map<Integer, ExampleClass> map3 = new LinkedHashMap();
        for (int i = 0; i < CONT; i++) {
            map3.put(i, new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultMap = DeepClone.clone(map3);

        /*********************************/

        final Map<Integer, ExampleClass> map4 = new WeakHashMap();
        for (int i = 0; i < CONT; i++) {
            map4.put(i, new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultMap = DeepClone.clone(map4);

        /*********************************/

        final Map<Integer, ExampleClass> map5 = new IdentityHashMap();
        for (int i = 0; i < CONT; i++) {
            map5.put(i, new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        resultMap = DeepClone.clone(map5);

        /*********************************/

        final Map<Size, ExampleClass> map6 = new EnumMap<Size, ExampleClass>(Size.class);

        map6.put(Size.L, new ExampleClass(new Integer(1), new BigDecimal(1)));
        map6.put(Size.M, new ExampleClass(new Integer(2), new BigDecimal(2)));

        final Map<Size, ExampleClass> resultEnuMap = DeepClone.clone(map6);

    }
}
