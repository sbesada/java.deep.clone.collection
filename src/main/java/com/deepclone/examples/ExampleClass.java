package com.deepclone.examples;

import java.math.BigDecimal;
import java.util.Objects;

public class ExampleClass implements Cloneable {
    private int id;
    private BigDecimal value;
    private String name;

    public ExampleClass(int id, BigDecimal value, String name) {
        this.id = id;
        this.value = value;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleClass that = (ExampleClass) o;
        return id == that.id &&
               Objects.equals(value, that.value) &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, name);
    }

    @Override
    public String toString() {
        return "ExampleClass{" +
               "id=" + id +
               ", value=" + value +
               ", name='" + name + '\'' +
               '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // Basic shallow clone for this example.
        // If ExampleClass had mutable fields that also need deep cloning,
        // those would need to be handled here.
        return super.clone();
    }
}
