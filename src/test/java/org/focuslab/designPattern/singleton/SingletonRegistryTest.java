package org.focuslab.designPattern.singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Akky on 06-04-2016.
 */

@RunWith(Parameterized.class)
public class SingletonRegistryTest {



   @Parameterized.Parameters
   public static Collection<Class[]> getClassNames(){
       return Arrays.asList(new Class[][] {{SingletonClazz1.class}});
   }

    @Parameterized.Parameter(value = 0)
    public Class clazz ;

    private Object singleton = null;

    @Test()
    public void getInstance() throws Exception {
        try {
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
           assertTrue(runnable1.s==runnable2.s);
        }
        catch (Exception e){
            fail(e.getMessage());
        }
    }

    private class SingletonRunnable implements Runnable{

        Object s ;

        @Override
        public void run() {

             this.s = SingletonRegistry.getInstance(clazz);
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