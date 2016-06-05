package designPattern.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akky on 06-04-2016.
 */
public class SingletonDoubleCheckingTest {

    private SingletonDoubleChecking singleton = null;

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

        SingletonDoubleChecking s = null;

        @Override
        public void run() {
            s = SingletonDoubleChecking.getInstance();
            if (singleton==null)
                singleton = s;
            try {
                Thread.sleep(20); // wait for 20 millisecond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}