package com.hdfclife;

import com.hdfclife.exception.InvalidIndexException;
import com.hdfclife.exception.QueueEmptyException;
import com.hdfclife.exception.StackEmptyException;
import com.hdfclife.list.ClaimLinkedList;
import com.hdfclife.list.CycleDetector;
import com.hdfclife.list.DigitListAdder;
import com.hdfclife.list.ListReverser;
import com.hdfclife.queue.BranchBfs;
import com.hdfclife.queue.CircularClaimQueue;
import com.hdfclife.queue.ClaimPriorityDesk;
import com.hdfclife.stack.ArrayClaimStack;
import com.hdfclife.stack.ParenthesesChecker;
import com.hdfclife.stack.PostfixEvaluator;
import com.hdfclife.thread.ClaimTotalCallable;
import com.hdfclife.thread.ProducerConsumer;
import com.hdfclife.thread.SeedRunnable;

import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class Main {

    static void main() {


        // 1. SLL Insert & Delete
        ClaimLinkedList list = new ClaimLinkedList();

        list.addLast(25000);
        list.addLast(18000);
        list.addLast(42000);
        list.addLast(15000);
        list.addLast(31000);
        list.addLast(9000);

        list.toArray();

        list.insertAt(2, 22000);

        list.toArray();

        list.deleteAt(2);

        list.toArray();

        // 2. List Reverse
        ListReverser.iterativeReverse(list.cloneList());

        ListReverser.recursiveReverse(list.cloneList());

        // 3. Middle & Cycle Detector using Tortoise and Hare
        CycleDetector.hasCycle(list);

        ClaimLinkedList cllClone = list.cloneList();

        ClaimLinkedList.ClaimNode tail = cllClone.getTail();

        tail.next = cllClone.nodeAt(2);

        CycleDetector.hasCycle(cllClone);

        // 4. Add Two Numbers

        ClaimLinkedList num1 = new ClaimLinkedList();

        num1.addLast(0);
        num1.addLast(0);
        num1.addLast(0);
        num1.addLast(5);
        num1.addLast(2);

        ClaimLinkedList num2 = new ClaimLinkedList();

        num2.addLast(0);
        num2.addLast(0);
        num2.addLast(0);
        num2.addLast(8);
        num2.addLast(1);

        DigitListAdder.sumList(num1, num2);


        // 5. Balanced Parenthesis & Check Palindrome

        System.out.println(ParenthesesChecker.isValidParenthesis("((TERM)(ULIP))"));
        System.out.println(ParenthesesChecker.isValidParenthesis("((TERM)(ULIP)"));
        System.out.println(ParenthesesChecker.isValidParenthesis("([)]"));

        System.out.println(PostfixEvaluator.evaluate("25000 18000 + 1000 -"));

        // 6. Circular Queue and BFS
        CircularClaimQueue circularClaimQueue = new CircularClaimQueue(4);

        circularClaimQueue.enqueue(25000);
        circularClaimQueue.enqueue(18000);
        circularClaimQueue.enqueue(42000);

        System.out.println(circularClaimQueue.dequeue());

        circularClaimQueue.enqueue(15000);
        circularClaimQueue.enqueue(31000);

        circularClaimQueue.display();

        BranchBfs.bfsTraversal("MUMBAI");

        // 7. Priority Queue
        ClaimPriorityDesk.printClaimsPQ();

        // 8. Threads
        SeedRunnable seedRunnable = new SeedRunnable();
        Thread thread = new Thread(seedRunnable);

        System.out.println(thread.getState());

        thread.start();

        try {

            thread.join();

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        System.out.println(thread.getState());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Integer> seedAmounts = List.of(25000, 18000, 42000, 15000, 31000, 9000);

        ClaimTotalCallable claimTotalCallable = new ClaimTotalCallable(seedAmounts);

        Future<Integer> future = executorService.submit(claimTotalCallable);
        Integer sumSeedAmounts = null;

        try {

            sumSeedAmounts = future.get();

        } catch (InterruptedException | ExecutionException e) {

            throw new RuntimeException(e);
        }

        System.out.println(sumSeedAmounts);

        System.out.println(future.isDone());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {

            int sum = 0;

            for(int seed: seedAmounts) {
                sum += seed;
            }

            return sum;
        });

        try {

            System.out.println(completableFuture.get());

        } catch (InterruptedException | ExecutionException e) {

            throw new RuntimeException(e);

        }

        Future<Void> sleep  = executorService.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        sleep.cancel(true);

        System.out.println(sleep.isCancelled());

        Thread daemonThread = new Thread(() -> {});
        daemonThread.setDaemon(true);

        System.out.println(daemonThread.isDaemon());

        try {
            ProducerConsumer.producerConsumerDemo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        // Exceptional Handling

        try {

            list.deleteAt(99);

        } catch(InvalidIndexException e) {

            System.out.println(e.getMessage());
        }

        ArrayClaimStack arrayClaimStack = new ArrayClaimStack(5);

        try{

            arrayClaimStack.pop();

        } catch (StackEmptyException e) {

            System.out.println(e.getMessage());

        }

        CircularClaimQueue circularClaimQueue1 = new CircularClaimQueue(2);
        try{

            circularClaimQueue1.dequeue();

        } catch (QueueEmptyException e) {

            System.out.println(e.getMessage());
        }

    }

}
