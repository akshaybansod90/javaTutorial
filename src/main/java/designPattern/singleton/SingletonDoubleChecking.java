package designPattern.singleton;

/**
 * Created by Akky on 06-04-2016.
 */
public class SingletonDoubleChecking {
    private static SingletonDoubleChecking singleton = null;

    private SingletonDoubleChecking(){}

    public static SingletonDoubleChecking getInstance(){
        if (singleton==null){
            synchronized (SingletonDoubleChecking.class){
                if (singleton==null){
                    singleton = new SingletonDoubleChecking();
                }
            }
        }
        return singleton;
    }
}
