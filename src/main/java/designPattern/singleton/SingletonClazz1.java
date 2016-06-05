package designPattern.singleton;

/**
 * Created by Akky on 08-04-2016.
 */
public class SingletonClazz1 {


    public static SingletonClazz1 getInstance() {
        return SingletonRegistry.getInstance(SingletonClazz1.class);
    }

    private SingletonClazz1() {
        // code for object initialization
    }
}
