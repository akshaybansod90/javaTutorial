package org.focuslab.designPattern.singleton;

/**
 * Created by Akky on 05-04-2016.
 */
public class SimpleSingleton {
    private static SimpleSingleton ourInstance = new SimpleSingleton();

    public static SimpleSingleton getInstance() {
        return ourInstance;
    }

    private SimpleSingleton() {
    }
}
