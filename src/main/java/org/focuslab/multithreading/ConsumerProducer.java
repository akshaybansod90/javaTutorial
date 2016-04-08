package org.focuslab.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Akky on 09-04-2016.
 */
public class ConsumerProducer {


    public static void main(String a[]) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        List<Integer> source = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            source.add(i);
        }

        Thread t1 = new Thread(new Producer<Integer>(blockingQueue, source));
        Thread t2 = new Thread(new Consumer<Integer>(blockingQueue));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
