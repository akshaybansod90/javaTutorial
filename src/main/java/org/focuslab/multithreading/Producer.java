package org.focuslab.multithreading;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Akky on 09-04-2016.
 */
public class Producer<T> implements Runnable {

    private BlockingQueue<T> blockingQueue = null;
    private List<T> list;

    public Producer(BlockingQueue<T> blockingQueue, List<T> list) {
        if (blockingQueue == null || list == null) {
            throw new IllegalArgumentException("blocking queue can not be null");
        }
        this.blockingQueue = blockingQueue;
        this.list = list;
    }

    public void produce(T data) throws InterruptedException {
        blockingQueue.put(data);
        System.out.println("Produced :" + data);
    }

    @Override
    public void run() {
        for (T t : list) {
            try {

                produce(t);
                TimeUnit.MICROSECONDS.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
