package com.deepclone;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.math.BigDecimal;
import com.deepclone.examples.ExampleClass; // Assuming ExampleClass is in this package

public class ImmutableCollectionsTest {

    @Test
    public void testImmutableListClone_Simple() {
        List<String> originalList = List.of("a", "b", "c");
        List<String> clonedList = DeepClone.clone(originalList);

        assertNotSame(originalList, clonedList);
        assertEquals(originalList.size(), clonedList.size());
        assertEquals(originalList, clonedList);
    }

    @Test
    public void testImmutableListClone_Complex() {
        ExampleClass obj1 = new ExampleClass(1, BigDecimal.ONE, "obj1");
        ExampleClass obj2 = new ExampleClass(2, BigDecimal.TEN, "obj2");
        List<ExampleClass> originalList = List.of(obj1, obj2);
        List<ExampleClass> clonedList = DeepClone.clone(originalList);

        assertNotSame(originalList, clonedList);
        assertEquals(originalList.size(), clonedList.size());
        assertEquals(originalList, clonedList); // Content equality

        // Assert that elements are cloned (different instances)
        assertNotSame(originalList.get(0), clonedList.get(0));
        assertNotSame(originalList.get(1), clonedList.get(1));
        assertEquals(originalList.get(0), clonedList.get(0)); // ExampleClass should have proper equals
        assertEquals(originalList.get(1), clonedList.get(1));
    }

    @Test
    public void testImmutableSetClone_Simple() {
        Set<String> originalSet = Set.of("a", "b", "c");
        Set<String> clonedSet = DeepClone.clone(originalSet);

        assertNotSame(originalSet, clonedSet);
        assertEquals(originalSet.size(), clonedSet.size());
        assertEquals(originalSet, clonedSet); // For sets, this checks element containment
    }

    @Test
    public void testImmutableSetClone_Complex() {
        ExampleClass obj1 = new ExampleClass(1, BigDecimal.ONE, "obj1");
        ExampleClass obj2 = new ExampleClass(2, BigDecimal.TEN, "obj2");
        Set<ExampleClass> originalSet = Set.of(obj1, obj2);
        Set<ExampleClass> clonedSet = DeepClone.clone(originalSet);

        assertNotSame(originalSet, clonedSet);
        assertEquals(originalSet.size(), clonedSet.size());
        assertEquals(originalSet, clonedSet);

        // To check if elements are new instances, we'd ideally iterate and check.
        // However, set iteration order is not guaranteed.
        // A common approach is to check if cloned elements are not the same as original ones
        // and that they are equal.
        // This requires ExampleClass to have a proper hashCode and equals method.
        for (ExampleClass originalItem : originalSet) {
            boolean foundAndCloned = false;
            for (ExampleClass clonedItem : clonedSet) {
                if (originalItem.equals(clonedItem) && originalItem != clonedItem) {
                    foundAndCloned = true;
                    break;
                }
            }
            assertTrue("Element " + originalItem + " was not properly cloned in the set.", foundAndCloned);
        }
    }

    @Test
    public void testImmutableMapClone_Simple() {
        Map<String, String> originalMap = Map.of("key1", "value1", "key2", "value2");
        Map<String, String> clonedMap = DeepClone.clone(originalMap);

        assertNotSame(originalMap, clonedMap);
        assertEquals(originalMap.size(), clonedMap.size());
        assertEquals(originalMap, clonedMap);
    }

    @Test
    public void testImmutableMapClone_ComplexValues() {
        ExampleClass val1 = new ExampleClass(1, BigDecimal.ONE, "val1");
        ExampleClass val2 = new ExampleClass(2, BigDecimal.TEN, "val2");
        Map<String, ExampleClass> originalMap = Map.of("key1", val1, "key2", val2);
        Map<String, ExampleClass> clonedMap = DeepClone.clone(originalMap);

        assertNotSame(originalMap, clonedMap);
        assertEquals(originalMap.size(), clonedMap.size());
        assertEquals(originalMap, clonedMap); // Content equality for map

        // Assert that value elements are cloned (different instances)
        assertNotSame(originalMap.get("key1"), clonedMap.get("key1"));
        assertNotSame(originalMap.get("key2"), clonedMap.get("key2"));
        assertEquals(originalMap.get("key1"), clonedMap.get("key1"));
        assertEquals(originalMap.get("key2"), clonedMap.get("key2"));
    }

    @Test
    public void testImmutableMapClone_ComplexKeys() {
        ExampleClass key1 = new ExampleClass(1, BigDecimal.ONE, "key1");
        ExampleClass key2 = new ExampleClass(2, BigDecimal.TEN, "key2");
        Map<ExampleClass, String> originalMap = Map.of(key1, "value1", key2, "value2");
        Map<ExampleClass, String> clonedMap = DeepClone.clone(originalMap);

        assertNotSame(originalMap, clonedMap);
        assertEquals(originalMap.size(), clonedMap.size());
        assertEquals(originalMap, clonedMap);

        // Assert that key elements are cloned (different instances)
        // This is tricky as we need to find the corresponding key in the cloned map.
        // It relies on ExampleClass having correct equals and hashCode.
        for (Map.Entry<ExampleClass, String> entry : originalMap.entrySet()) {
            ExampleClass originalKey = entry.getKey();
            String value = entry.getValue();

            ExampleClass clonedKeyEquivalent = null;
            for (ExampleClass clonedKeyCandidate : clonedMap.keySet()) {
                if (originalKey.equals(clonedKeyCandidate)) {
                    clonedKeyEquivalent = clonedKeyCandidate;
                    break;
                }
            }
            assertNotNull("Equivalent key for " + originalKey + " not found in cloned map.", clonedKeyEquivalent);
            assertNotSame(originalKey, clonedKeyEquivalent);
            assertEquals(value, clonedMap.get(clonedKeyEquivalent));
        }
    }

    @Test
    public void testImmutableMapClone_ComplexKeysAndValues() {
        ExampleClass key1 = new ExampleClass(1, BigDecimal.ONE, "key1");
        ExampleClass val1 = new ExampleClass(10, BigDecimal.valueOf(100), "val1");
        ExampleClass key2 = new ExampleClass(2, BigDecimal.TEN, "key2");
        ExampleClass val2 = new ExampleClass(20, BigDecimal.valueOf(200), "val2");

        Map<ExampleClass, ExampleClass> originalMap = Map.of(key1, val1, key2, val2);
        Map<ExampleClass, ExampleClass> clonedMap = DeepClone.clone(originalMap);

        assertNotSame(originalMap, clonedMap);
        assertEquals(originalMap.size(), clonedMap.size());
        assertEquals(originalMap, clonedMap); // Checks if maps are equal based on entrySet equality.

        for (Map.Entry<ExampleClass, ExampleClass> entry : originalMap.entrySet()) {
            ExampleClass originalKey = entry.getKey();
            ExampleClass originalValue = entry.getValue();

            ExampleClass clonedKeyEquivalent = null;
            ExampleClass clonedValueFromMap = null;

            for (Map.Entry<ExampleClass, ExampleClass> clonedEntry : clonedMap.entrySet()) {
                if (originalKey.equals(clonedEntry.getKey())) {
                    clonedKeyEquivalent = clonedEntry.getKey();
                    clonedValueFromMap = clonedEntry.getValue();
                    break;
                }
            }
            assertNotNull("Equivalent key for " + originalKey + " not found in cloned map.", clonedKeyEquivalent);
            assertNotSame(originalKey, clonedKeyEquivalent, "Key object for " + originalKey + " should be a new instance.");
            assertEquals(originalKey, clonedKeyEquivalent, "Key content for " + originalKey + " should be equal.");

            assertNotNull("Value for key " + originalKey + " not found in cloned map.", clonedValueFromMap);
            assertNotSame(originalValue, clonedValueFromMap, "Value object for key " + originalKey + " should be a new instance.");
            assertEquals(originalValue, clonedValueFromMap, "Value content for key " + originalKey + " should be equal.");
        }
    }
}
