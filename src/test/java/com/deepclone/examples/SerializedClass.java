package com.deepclone.examples;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author Sergio Besada
 * 
 */
public class SerializedClass implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    public Integer number1;

    public BigDecimal number2;

    public SerializedClass() {

    }

    public SerializedClass(final Integer number1, final BigDecimal number2) {
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

    // Important: the best way (most optimal way) is calling super.clone but the method must to be public.
    // If you use a protected method deepClone works properly but is a slower than if you use a public method.
    // Checked it!!!

    // protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub return
    // return super.clone();
    // }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub return
        return super.clone();
    }

    @Override
    public String toString() {
        return "ClassSerialized [number1=" + this.number1 + ", number2=" + this.number2 + "]";
    }

}
