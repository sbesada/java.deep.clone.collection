package com.deepclone;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SimpleTest {

    public static int MILLION = 1000000;

    @Test
    public void Test_Simple() {

        // TODO Auto-generated constructor stub

        final List<String> listaString = new ArrayList();

        for (int i = 0; i < MILLION; i++) {
            listaString.add(new String("string" + i));
        }

        // / clone 1
        long time = System.currentTimeMillis();

        final List<String> listaStringClone = new ArrayList();

        for (final String string : listaString) {
            listaStringClone.add(string);

        }
        System.out.println("SimpleTest: List<String> direct method result  " + (System.currentTimeMillis() - time));

        // / clone 2
        time = System.currentTimeMillis();
        List<String> listaStringClone2 = new ArrayList();

        listaStringClone2 = (List<String>) ((ArrayList<String>) listaString).clone();

        System.out.println("SimpleTest: List<String> clone list result  " + (System.currentTimeMillis() - time));

        // / clone 3
        time = System.currentTimeMillis();
        List<String> listaStringClone3 = new ArrayList();
        listaStringClone3 = DeepClone.clone(listaString);

        System.out.println("SimpleTest: List<String> deep clone" + (System.currentTimeMillis() - time));

    }
}
