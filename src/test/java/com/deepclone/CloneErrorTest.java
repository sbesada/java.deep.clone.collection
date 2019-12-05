package com.deepclone;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.deepclone.examples.ExampleClass;

public class CloneErrorTest {

    @Test
    public void Test_CloneError() {

        final Integer numero1 = 1;
        final BigDecimal numero2 = new BigDecimal(22);

        final ExampleClass classExample = new ExampleClass(numero1, numero2);

        final List<Map<Integer, List<ExampleClass>>> mulList = new ArrayList<Map<Integer, List<ExampleClass>>>();

        final HashMap<Integer, List<ExampleClass>> map = new HashMap<Integer, List<ExampleClass>>();

        final List<ExampleClass> list = new ArrayList<ExampleClass>();
        list.add(classExample);
        map.put(1, list);

        mulList.add(map);

        final List<Map<Integer, List<ExampleClass>>> listamul2 = DeepClone.clone(mulList);

        final List<Map<Integer, List<ExampleClass>>> listamul3 = (List<Map<Integer, List<ExampleClass>>>) ((ArrayList) mulList)
                .clone();

        classExample.setNumber1(2);
        classExample.setNumber2(new BigDecimal(444));

        System.out.println("Inspect the mulList2 & mulList3");

    }

}
