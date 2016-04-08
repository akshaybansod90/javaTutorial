package org.focuslab.designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akky on 06-04-2016.
 */

public class SingletonRegistry {

    private static Map<Class,Object> registry = new HashMap<Class, Object>();

    private SingletonRegistry(){}

    public static <T>  T getInstance(Class clazz){

       if (clazz==null)
       {
           throw new IllegalArgumentException();
       }


        Object singleton = registry.get(clazz);

        if (singleton==null){

                synchronized (clazz) {
                    try {

                        Constructor constructor = clazz.getDeclaredConstructor(null);
                        constructor.setAccessible(true);
                        singleton = constructor.newInstance();
                        constructor.setAccessible(false);
                        registry.put(clazz, singleton);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
        }

        return null;//(T) clazz.cast(singleton);

    }


}
