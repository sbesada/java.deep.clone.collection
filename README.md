# java.deep.clone.collection
Java deep clone collection is a maven project that lets you clone whatever collection in java. This tool clones collections with serializable and non serializable classes. The non serializable clases have to implement cloneable.

If you have a lot of serializable clases with a lot of collections, People usually use a serializedClone algorithm to clone their data but this method is extremly slow. For this rerason, I have implemented this tool.

## Java Collections that you can clone

+ Interface List (https://docs.oracle.com/javase/6/docs/api/java/util/List.html)
  + ArrayList
  + LinkedList
  + CopyOnWriteArrayList,

+ Interface Set (https://docs.oracle.com/javase/6/docs/api/java/util/Set.html)
  + HashSet
  + TreeSet
  + LinkedHashSet
  + EnumSet
  + CopyOnWriteArraySet,

+ Interface Map (https://docs.oracle.com/javase/6/docs/api/java/util/Map.html)
  + HashMap
  + TreeMap
  + LinkedHashMap
  + EnumMap
  + WeakHashMap
  + IdentityHashMap
  
+ Interface Queue (https://docs.oracle.com/javase/6/docs/api/java/util/Queue.html)
  + PriorityQueue
  + LinkedBlockingQueue
  + ArrayBlockingQueue
  + PriorityBlockingQueue
  + DelayQueue
  + SynchronousQueue,

+ Interface Dequeue (https://docs.oracle.com/javase/6/docs/api/java/util/Deque.html)
  + ArrayDeque
  + LinkedBlockingDeque

## How to clone a java collection

Here you can see an example:

        final List<ExampleClass> list1 = new ArrayList<ExampleClass>();

        for (int i = 0; i < MILLION; i++) {
            list1.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }


        List<ExampleClass> cloneList = new ArrayList<ExampleClass>();
        cloneList = DeepClone.clone(list1);
        

In the test package you can see more examples. 

This version is compiled for java 1.6

Enjoy it!!!

PD: if you think that my work deserves a donation, you can do it: https://sbesada.github.io/
