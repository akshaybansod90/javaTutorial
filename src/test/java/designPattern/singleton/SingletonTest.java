package designPattern.singleton;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Created by Akky on 05-04-2016.
 */

public class SingletonTest {

    private Singleton singleton = null;




    @Test
    public void getInstance() throws Exception {
        SingletonRunnable runnable1 = new SingletonRunnable();
        SingletonRunnable runnable2 = new SingletonRunnable();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertNotNull(runnable1.s);
        assertNotNull(runnable2.s);
        assertTrue(runnable1.s == runnable2.s);

    }

    private class SingletonRunnable implements Runnable{
        Singleton s = null;
        @Override
        public void run() {
            s = Singleton.getInstance();
            if (singleton==null)
                singleton = s;
            try {
                Thread.sleep(20); // wait for 20 millisecond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertTrue(s==singleton);
        }
    }

    @Test(expected = IllegalAccessException.class)
    public void getInstanceByReflection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        singleton = (Singleton) Class.forName("Singleton").newInstance();

    }
    class MyClassLoader extends ClassLoader{

        public MyClassLoader(){
            super(Singleton.class.getClassLoader());
        }
    }
    @Test
    public void testByDifferentClassLoader(){
        try {

            Singleton s1 = (Singleton)  Class.forName(Singleton.class.getCanonicalName())
                    .getDeclaredMethod("getInstance",null).invoke(null,null);

            Singleton s2 = (Singleton) Class.forName(Singleton.class.getCanonicalName(),false,new MyClassLoader())
                    .getDeclaredMethod("getInstance",null).invoke(null,null);



            assertTrue(s1==s2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeserializeInstance(){
        Singleton singletonObject = Singleton.getInstance();
        try {
            File file = File.createTempFile("Singleton",".ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(singletonObject);
            outputStream.flush();
            outputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            Singleton singleton1 = (Singleton) inputStream.readObject();
            inputStream.close();

            ObjectInputStream inputStream1 = new ObjectInputStream(new FileInputStream(file));
            Singleton singleton2 = (Singleton) inputStream1.readObject();
            assertTrue(singleton1==singleton2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}