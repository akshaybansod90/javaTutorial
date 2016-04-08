package org.focuslab.designPattern.singleton;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Akky on 05-04-2016.
 */
public class SimpleSingletonTest {

    private SimpleSingleton simpleSingleton = null;

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

    @Test(expected = IllegalAccessException.class)
    public void getInstanceByReflection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        simpleSingleton = (SimpleSingleton) Class.forName("org.focuslab.designPattern.singleton.SimpleSingleton").newInstance();

    }

    private class SingletonRunnable implements Runnable{
        SimpleSingleton s = null;
        @Override
        public void run() {
            s = SimpleSingleton.getInstance();
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