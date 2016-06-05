package designPattern.singleton;

import java.io.Serializable;

/**
 * Created by Akky on 05-04-2016.
 */
public class Singleton implements Serializable {

    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {

    }

    private Object readResolve(){
        return  ourInstance;
    }
}
