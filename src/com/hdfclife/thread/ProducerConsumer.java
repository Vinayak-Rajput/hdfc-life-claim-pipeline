package com.hdfclife.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
    static List<Integer> consumed = new ArrayList<>();

    public static void producerConsumerDemo() throws InterruptedException {
        Thread producer = new Thread(() -> {
            try {

                queue.put(25000);
                queue.put(18000);
                queue.put(42000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread consumer = new Thread(() -> {
            try {
                for(int i = 0; i < 3; i++) {
                    consumed.add(queue.take());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        for(int val: consumed) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


}
