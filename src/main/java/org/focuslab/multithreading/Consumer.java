package org.focuslab.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Akky on 09-04-2016.
 */
public class Consumer<T> implements Runnable {
    private BlockingQueue<T> blockingQueue = null;

    public Consumer(BlockingQueue<T> blockingQueue) {
        if (blockingQueue == null) {
            throw new IllegalArgumentException("blocking queue can not be null");
        }
        this.blockingQueue = blockingQueue;
    }

    public void consume() throws InterruptedException {

        T data = blockingQueue.take();
        //process data ;
        TimeUnit.MICROSECONDS.sleep((int) (Math.random() * 1000));
        System.out.println("Consumed :" + data.toString());

    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
