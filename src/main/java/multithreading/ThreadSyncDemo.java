package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Akky on 08-04-2016.
 */

public class ThreadSyncDemo{


    public static void main(String a[]) {

        List<Integer> integers = new ArrayList<Integer>();
        BlockingQueue<Integer> blockingQueueOdd = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue<Integer> blockingQueueEven = new ArrayBlockingQueue<Integer>(1);

        for (int i = 0; i < 50; i++) {
            integers.add(i);
        }

        Thread t1 = new Thread(new Producer<Integer>(blockingQueueOdd, true, integers));
        Thread t2 = new Thread(new Producer<Integer>(blockingQueueEven, false, integers));
        Thread t3 = new Thread(new Consumer<Integer>(blockingQueueOdd, blockingQueueEven));
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Consumer<T> implements Runnable {

        BlockingQueue<T> blockingQueueOdd;
        BlockingQueue<T> blockingQueueEven;


        public Consumer(BlockingQueue<T> blockingQueueOdd, BlockingQueue<T> blockingQueueEven) {
            this.blockingQueueOdd = blockingQueueOdd;
            this.blockingQueueEven = blockingQueueEven;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(blockingQueueOdd.take());
                    System.out.println(blockingQueueEven.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Producer<T> implements Runnable {

        BlockingQueue<T> blockingQueue;
        boolean isOddProducer;
        List<T> list;

        Producer(BlockingQueue<T> blockingQueue, boolean isOddProducer, List<T> list) {
            this.blockingQueue = blockingQueue;
            this.isOddProducer = isOddProducer;
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = isOddProducer ? 0 : 1; i < list.size(); i = i + 2) {
                try {
                    blockingQueue.put(list.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}