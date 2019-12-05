package com.deepclone;

import java.lang.reflect.Method;

public class TypeCloneResult {

    private TypeClone typeClone;

    private Method method;

    private Class element;

    /**
     * TypeCloneResult
     */
    public TypeCloneResult() {
    }

    /**
     * TypeCloneResult
     * 
     * @param typeClone
     * @param method
     */
    public TypeCloneResult(final TypeClone typeClone, final Method method) {
        this.typeClone = typeClone;
        this.method = this.method;

    }

    /**
     * 
     * getTypeClone
     * 
     * @return
     */
    public TypeClone getTypeClone() {
        return this.typeClone;
    }

    /**
     * 
     * setTypeClone
     * 
     * @param typeClone
     */
    public void setTypeClone(final TypeClone typeClone) {
        this.typeClone = typeClone;
    }

    /**
     * 
     * getMethod
     * 
     * @return
     */
    public Method getMethod() {
        return this.method;
    }

    /**
     * 
     * setMethod
     * 
     * @param method
     */
    public void setMethod(final Method method) {
        this.method = method;
    }

    /**
     * 
     * getElement
     * 
     * @return
     */
    public Class getElement() {
        return this.element;
    }

    /**
     * 
     * setElement
     * 
     * @param element
     */
    public void setElement(final Class element) {
        this.element = element;
    }

}
