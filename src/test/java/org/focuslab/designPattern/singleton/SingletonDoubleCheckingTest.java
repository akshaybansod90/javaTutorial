package org.focuslab.designPattern.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akky on 06-04-2016.
 */
public class SingletonDoubleCheckingTest {

    private SingletonDoubleChecking singleton = null;

    @Test
    public void getInstance() throws Exception {

        Thread thread1 = new Thread(new SingletonRunnable());
        Thread thread2 = new Thread(new SingletonRunnable());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private class SingletonRunnable implements Runnable{

        @Override
        public void run() {
            SingletonDoubleChecking s = SingletonDoubleChecking.getInstance();
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

}