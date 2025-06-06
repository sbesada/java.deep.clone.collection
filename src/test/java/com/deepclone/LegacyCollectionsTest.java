package com.deepclone;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Vector;
import java.util.Stack;
import java.math.BigDecimal;
import com.deepclone.examples.ExampleClass; // Assuming ExampleClass is in this package

public class LegacyCollectionsTest {

    // --- Vector Tests ---

    @Test
    public void testEmptyVectorClone() {
        Vector<String> originalVector = new Vector<>();
        Vector<String> clonedVector = DeepClone.clone(originalVector);

        assertNotNull(clonedVector);
        assertNotSame(originalVector, clonedVector);
        assertTrue(clonedVector.isEmpty());
        assertEquals(originalVector, clonedVector);
    }

    @Test
    public void testVectorWithStringsClone() {
        Vector<String> originalVector = new Vector<>();
        originalVector.add("Hello");
        originalVector.add("World");
        originalVector.add("Test");

        Vector<String> clonedVector = DeepClone.clone(originalVector);

        assertNotSame(originalVector, clonedVector);
        assertEquals(originalVector.size(), clonedVector.size());
        assertEquals(originalVector, clonedVector);
    }

    @Test
    public void testVectorWithExampleClassClone() {
        ExampleClass obj1 = new ExampleClass(1, BigDecimal.ONE, "VectorObj1");
        ExampleClass obj2 = new ExampleClass(2, BigDecimal.TEN, "VectorObj2");

        Vector<ExampleClass> originalVector = new Vector<>();
        originalVector.add(obj1);
        originalVector.add(obj2);

        Vector<ExampleClass> clonedVector = DeepClone.clone(originalVector);

        assertNotSame(originalVector, clonedVector);
        assertEquals(originalVector.size(), clonedVector.size());
        assertEquals(originalVector, clonedVector); // Checks content equality based on ExampleClass.equals

        // Assert that elements within the Vector are new instances
        assertNotNull(clonedVector.get(0));
        assertNotSame(originalVector.get(0), clonedVector.get(0));
        assertEquals(originalVector.get(0), clonedVector.get(0));

        assertNotNull(clonedVector.get(1));
        assertNotSame(originalVector.get(1), clonedVector.get(1));
        assertEquals(originalVector.get(1), clonedVector.get(1));
    }

    // --- Stack Tests ---

    @Test
    public void testEmptyStackClone() {
        Stack<String> originalStack = new Stack<>();
        Stack<String> clonedStack = DeepClone.clone(originalStack);

        assertNotNull(clonedStack);
        assertNotSame(originalStack, clonedStack);
        assertTrue(clonedStack.isEmpty());
        assertEquals(originalStack, clonedStack);
    }

    @Test
    public void testStackWithStringsClone() {
        Stack<String> originalStack = new Stack<>();
        originalStack.push("First");
        originalStack.push("Second");
        originalStack.push("Third");

        Stack<String> clonedStack = DeepClone.clone(originalStack);

        assertNotSame(originalStack, clonedStack);
        assertEquals(originalStack.size(), clonedStack.size());
        assertEquals(originalStack, clonedStack); // Stack's equals method checks content
    }

    @Test
    public void testStackWithExampleClassClone() {
        ExampleClass obj1 = new ExampleClass(10, BigDecimal.valueOf(10.0), "StackObj1");
        ExampleClass obj2 = new ExampleClass(20, BigDecimal.valueOf(20.0), "StackObj2");

        Stack<ExampleClass> originalStack = new Stack<>();
        originalStack.push(obj1);
        originalStack.push(obj2);

        Stack<ExampleClass> clonedStack = DeepClone.clone(originalStack);

        assertNotSame(originalStack, clonedStack);
        assertEquals(originalStack.size(), clonedStack.size());
        assertEquals(originalStack, clonedStack); // Checks content equality based on ExampleClass.equals

        // Assert that elements within the Stack are new instances
        // Stack iteration order is LIFO, so element at index 0 is the last pushed.
        // For direct comparison, it's often easier to pop or use get(index) carefully.
        assertNotNull(clonedStack.get(0));
        assertNotSame(originalStack.get(0), clonedStack.get(0));
        assertEquals(originalStack.get(0), clonedStack.get(0));

        assertNotNull(clonedStack.get(1));
        assertNotSame(originalStack.get(1), clonedStack.get(1));
        assertEquals(originalStack.get(1), clonedStack.get(1));

        // To be absolutely sure about stack specific behavior (LIFO) and cloned elements:
        Stack<ExampleClass> originalCopyForIteration = new Stack<>();
        originalCopyForIteration.addAll(originalStack);
        Stack<ExampleClass> clonedCopyForIteration = new Stack<>();
        clonedCopyForIteration.addAll(clonedStack);

        assertEquals(originalCopyForIteration.size(), clonedCopyForIteration.size());
        while(!originalCopyForIteration.isEmpty()){
            ExampleClass originalItem = originalCopyForIteration.pop();
            ExampleClass clonedItem = clonedCopyForIteration.pop();
            assertNotSame(originalItem, clonedItem);
            assertEquals(originalItem, clonedItem);
        }
    }
}
