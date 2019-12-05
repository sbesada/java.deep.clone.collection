package com.deepclone;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.deepclone.examples.SerializedClass;

public class CloneErrorTest2 {

    @Test
    public void Test_CloneError2() {

        final Integer number1 = 1;
        final BigDecimal numero2 = new BigDecimal(22);

        final SerializedClass objeto = new SerializedClass(number1, numero2);

        final List<Map<Integer, List<SerializedClass>>> mulList = new ArrayList<Map<Integer, List<SerializedClass>>>();

        final HashMap<Integer, List<SerializedClass>> map = new HashMap<Integer, List<SerializedClass>>();

        final List<SerializedClass> list = new ArrayList<SerializedClass>();
        list.add(objeto);
        map.put(1, list);

        mulList.add(map);

        final List<Map<Integer, List<SerializedClass>>> mulList2 = DeepClone.clone(mulList);

        final List<Map<Integer, List<SerializedClass>>> mulList3 = (List<Map<Integer, List<SerializedClass>>>) ((ArrayList) mulList)
                .clone();

        objeto.setNumber1(2);
        objeto.setNumber2(new BigDecimal(444));

        System.out.println("Inspect the mulList2 & mulList3");

    }
}
