package com.deepclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

/**
 * 
 * 
 * @author Sergio Besada
 */
public class DeepClone {

    /**
     * 
     * clone
     * 
     * @param element
     * @return
     */
    public static <T, K, V> T clone(final T element) {

        final TypeCloneResult typeCloneResult = typeClone(element);

        T result = null;

        if (element != null) {
            switch (typeCloneResult.getTypeClone()) {

            case CloneClass:

                final Method method = typeCloneResult.getMethod();
                try {
                    result = (T) method.invoke(element);
                } catch (final IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (final InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;

            case Collection:
                result = (T) UtilCollection.clone((Collection<T>) element);

                break;

            case Map:
                result = (T) UtilMap.clone((Map<K, V>) element);

                break;

            default:

                result = element;
                break;
            }
        }
        return result;

    }

    /**
     * 
     * serializedClone
     * 
     * @param object
     * @return
     */
    public static <T> T serializedClone(final T object) {

        Object result = null;
        if (Serializable.class.isAssignableFrom(object.getClass())) {

            ByteArrayOutputStream baos = null;
            ObjectOutputStream oos = null;
            ByteArrayInputStream bais = null;
            ObjectInputStream ois = null;
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);

                final byte[] payload = baos.toByteArray();

                bais = new ByteArrayInputStream(payload);
                ois = new ObjectInputStream(bais);
                try {
                    result = ois.readObject();
                } catch (final ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (final IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (baos != null) {
                        baos.close();
                    }

                    if (oos != null) {
                        oos.close();
                    }
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }

                } catch (final IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        return (T) result;
    }

    /*************************************************************************/

    /**
     * 
     * typeClone
     * 
     * @param element
     * @return
     */
    public static <T> TypeCloneResult typeClone(final T element) {

        final TypeCloneResult result = new TypeCloneResult();

        final Class clazz = element.getClass();

        if (Map.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.Map);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            result.setTypeClone(TypeClone.Collection);

        } else if (Cloneable.class.isAssignableFrom(element.getClass())) {
            try {
                result.setTypeClone(TypeClone.CloneClass);
                result.setMethod(clazz.getDeclaredMethod("clone"));
            } catch (final SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (final NoSuchMethodException e) {
                e.printStackTrace();
            }

        } else {

            result.setTypeClone(TypeClone.NotCloneClass);
        }
        return result;

    }

}
