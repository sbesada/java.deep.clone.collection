package com.deepclone;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.deepclone.examples.ExampleClass;

public class ComposeCollectionTest {

    public static int MILLION = 1000000;

    @Test
    public void Test_ComposedCollection() {

        final List<Map<Integer, List<ExampleClass>>> multList = new ArrayList<Map<Integer, List<ExampleClass>>>();

        final HashMap<Integer, List<ExampleClass>> map = new HashMap<Integer, List<ExampleClass>>();

        final List<ExampleClass> list = new ArrayList<ExampleClass>();
        for (int i = 0; i < MILLION; i++) {
            final BigDecimal bigDecimal = new BigDecimal(i);

            final ExampleClass clase1 = new ExampleClass(i, bigDecimal);
            list.add(clase1);
        }
        map.put(1, list);
        multList.add(map);

        // ************* clone 1 *********************/
        long time = System.currentTimeMillis();

        final List<Map<Integer, List<ExampleClass>>> multListClone = new ArrayList<Map<Integer, List<ExampleClass>>>();

        final HashMap<Integer, List<ExampleClass>> mapClone = new HashMap<Integer, List<ExampleClass>>();

        for (final Map<Integer, List<ExampleClass>> map2 : multList) {

            for (final Map.Entry<Integer, List<ExampleClass>> entry : map2.entrySet()) {
                final List<ExampleClass> listaClone = new ArrayList<ExampleClass>();
                for (final ExampleClass element : entry.getValue()) {
                    try {
                        listaClone.add(element.clone());
                    } catch (final CloneNotSupportedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                mapClone.put(entry.getKey(), listaClone);

            }

        }

        multListClone.add(mapClone);

        System.out.println("Test_ComposedCollection result 1 direct method: " + (System.currentTimeMillis() - time));

        // *****************************************************

        // ************* clone 2 *********************/
        time = System.currentTimeMillis();
        final List<Map<Integer, List<ExampleClass>>> multListClone2 = DeepClone.clone(multList);

        System.out.println("Test_ComposedCollection result 2 deepClone: " + (System.currentTimeMillis() - time));

        // Execute a couple of times this test to kwnow the speed

        // *******************************************************
    }

}