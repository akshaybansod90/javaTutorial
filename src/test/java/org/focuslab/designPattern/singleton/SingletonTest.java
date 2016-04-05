package org.focuslab.designPattern.singleton;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Akky on 05-04-2016.
 */
public class SingletonTest {

    private Singleton singleton = null;

    @Test
    public void getInstance() throws Exception {

        Thread thread1 = new Thread(new SingletonRunnable());
        Thread thread2 = new Thread(new SingletonRunnable());
        thread1.start();
        thread2.start();

    }

    @Test(expected = IllegalAccessException.class)
    public void getInstanceByReflection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        singleton = (Singleton) Class.forName("org.focuslab.designPattern.singleton.Singleton").newInstance();

    }

    private class SingletonRunnable implements Runnable{

        @Override
        public void run() {
            Singleton s = Singleton.getInstance();
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