package org.focuslab.designPattern.singleton;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Akky on 05-04-2016.
 */
public class SimpleSingletonTest {

    private SimpleSingleton simpleSingleton = null;

    @Test
    public void getInstance() throws Exception {

        Thread thread1 = new Thread(new SingletonRunnable());
        Thread thread2 = new Thread(new SingletonRunnable());
        thread1.start();
        thread2.start();

    }

    @Test(expected = IllegalAccessException.class)
    public void getInstanceByReflection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        simpleSingleton = (SimpleSingleton) Class.forName("org.focuslab.designPattern.singleton.SimpleSingleton").newInstance();

    }

    private class SingletonRunnable implements Runnable{

        @Override
        public void run() {
            SimpleSingleton s = SimpleSingleton.getInstance();
            if (simpleSingleton==null)
            simpleSingleton = s;
            try {
                Thread.sleep(20); // wait for 20 millisecond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertTrue(s==simpleSingleton);
        }
    }
}