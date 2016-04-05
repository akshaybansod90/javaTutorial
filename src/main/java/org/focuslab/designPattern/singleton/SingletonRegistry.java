package org.focuslab.designPattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akky on 06-04-2016.
 */
public class SingletonRegistry {
    private Map<String,Object> registry = new HashMap<String, Object>();
    public static SingletonRegistry singletonRegistry = new SingletonRegistry();

    private SingletonRegistry(){}

    public static Object getInstance(String className){
       return null;
    }


}
