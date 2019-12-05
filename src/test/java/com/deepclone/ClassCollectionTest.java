package com.deepclone;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.deepclone.examples.ExampleClass;

public class ClassCollectionTest {

    public static int MILLION = 1000000;

    @Test
    public void Test_ClassCollection() {

        final List<ExampleClass> list1 = new ArrayList<ExampleClass>();

        for (int i = 0; i < MILLION; i++) {
            list1.add(new ExampleClass(new Integer(i), new BigDecimal(i)));
        }

        // ************************* ditect clone 1 ************************/
        long time = System.currentTimeMillis();

        final List<ExampleClass> cloneList1 = new ArrayList<ExampleClass>();

        for (final ExampleClass classExample : list1) {
            try {
                cloneList1.add(classExample.clone());
            } catch (final CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("ClassCollectionTest: result direct clone " + (System.currentTimeMillis() - time));

        // *********************************** deepClone
        time = System.currentTimeMillis();
        List<ExampleClass> cloneList2 = new ArrayList<ExampleClass>();
        cloneList2 = DeepClone.clone(list1);

        System.out.println("ClassCollectionTest result deepclone " + (System.currentTimeMillis() - time));

    }
}
