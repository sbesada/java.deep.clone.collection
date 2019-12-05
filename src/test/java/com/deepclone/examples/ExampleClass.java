package com.deepclone.examples;

import java.math.BigDecimal;

/**
 * 
 * 
 * @author Sergio Besada
 * 
 */
public class ExampleClass implements Cloneable, Comparable {

    public Integer number1;

    public BigDecimal number2;

    public ExampleClass(final Integer number1, final BigDecimal number2) {
        this.number1 = number1;
        this.number2 = number2;

    }

    public Integer getNumber1() {
        return this.number1;
    }

    public void setNumber1(final Integer number1) {
        this.number1 = number1;
    }

    public BigDecimal getNumber2() {
        return this.number2;
    }

    public void setNumber2(final BigDecimal number2) {
        this.number2 = number2;
    }

    @Override
    public int compareTo(final Object arg0) {
        return this.number1.compareTo(((ExampleClass) arg0).number1);
    }

    // TODO: Use public method to implement the clone!!!. It's faster than protected method
    @Override
    public ExampleClass clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return new ExampleClass(this.number1, this.number2);
    }

    @Override
    public String toString() {
        return "TestClass [number1=" + this.number1 + ", number2=" + this.number2 + "]";
    }

}
