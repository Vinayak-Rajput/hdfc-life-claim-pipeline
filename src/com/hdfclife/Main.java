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

import java.util.List;
import java.util.concurrent.*;

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

        System.out.print("1. Seed list -> ");
        list.toArray();

        list.insertAt(2, 22000);

        System.out.print("2. After insertAt(2, 22000) -> ");
        list.toArray();

        list.deleteAt(2);

        System.out.print("3. After deleteAt(2) -> ");
        list.toArray();

        // 2. List Reverse
        System.out.print("4. Reverse iterative -> ");
        ListReverser.iterativeReverse(list.cloneList());

        System.out.print("5. Reverse recursive -> ");
        ListReverser.recursiveReverse(list.cloneList());

        // 3. Middle & Cycle Detector using Tortoise and Hare
        System.out.print("6. Middle of seed -> ");
        CycleDetector.middleValue(list);

        System.out.print("7. hasCycle on seed -> ");
        CycleDetector.hasCycle(list);

        ClaimLinkedList cllClone = list.cloneList();
        ClaimLinkedList.ClaimNode tail = cllClone.getTail();
        tail.next = cllClone.nodeAt(2);

        System.out.print("8. hasCycle after linking tail to index 2 -> ");
        int startCycleAmount = CycleDetector.hasCycle(cllClone);

        System.out.println("9. Cycle start amount -> " + startCycleAmount);

        tail.next = null; // Breaking the Cycle for copied Cyclic Linked List

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

        System.out.print("10. Add-two-numbers -> ");
        DigitListAdder.sumList(num1, num2).toArray();

        // 5. Balanced Parenthesis & Check Palindrome
        System.out.println("11. Balanced ((TERM)(ULIP)) → " + ParenthesesChecker.isValidParenthesis("((TERM)(ULIP))"));
        System.out.println("12. Balanced ((TERM)(ULIP) → " + ParenthesesChecker.isValidParenthesis("((TERM)(ULIP)"));
        System.out.println("13. Balanced ([)] → " + ParenthesesChecker.isValidParenthesis("([)]"));

        System.out.println("14. Postfix 25000 18000 + 1000 - -> " + PostfixEvaluator.evaluate("25000 18000 + 1000 -"));

        // 6. Circular Queue and BFS
        CircularClaimQueue circularClaimQueue = new CircularClaimQueue(4);
        circularClaimQueue.enqueue(25000);
        circularClaimQueue.enqueue(18000);
        circularClaimQueue.enqueue(42000);

        System.out.println("15. Circular dequeue -> " + circularClaimQueue.dequeue());

        circularClaimQueue.enqueue(15000);
        circularClaimQueue.enqueue(31000);

        System.out.print("16. Circular queue after wrap -> ");
        circularClaimQueue.display();

        System.out.print("17. BFS from MUMBAI -> ");
        BranchBfs.bfsTraversal("MUMBAI");

        // 7. Priority Queue
        System.out.print("18. PriorityQueue poll ids -> ");
        ClaimPriorityDesk.printClaimsPQ();

        // 8. Threads
        SeedRunnable seedRunnable = new SeedRunnable();
        Thread thread = new Thread(seedRunnable);

        System.out.println("19. Thread state before start -> " + thread.getState());

        thread.start();

        try {

            thread.join();

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        System.out.println("20. Thread state after join -> " + thread.getState());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Integer> seedAmounts = List.of(25000, 18000, 42000, 15000, 31000, 9000);

        // The blocking get() waits for the worker; the extra space is the worker's stack, not an extra O(n) array
        ClaimTotalCallable claimTotalCallable = new ClaimTotalCallable(seedAmounts);

        Future<Integer> future = executorService.submit(claimTotalCallable);
        Integer sumSeedAmounts = null;

        try {

            sumSeedAmounts = future.get();

        } catch (InterruptedException | ExecutionException e) {

            throw new RuntimeException(e);
        }

        System.out.println("21. Callable Future.get() sum -> " + sumSeedAmounts);

        System.out.println("22. isDone after get -> "+future.isDone());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {

            int sum = 0;

            for(int seed: seedAmounts) {
                sum += seed;
            }

            return sum;
        });

        try {

            System.out.println("23. CompletableFuture.supplyAsync sum -> " + completableFuture.get());

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

        System.out.println("24. Cancelled future -> " + sleep.isCancelled());

        Thread daemonThread = new Thread(() -> {});
        daemonThread.setDaemon(true);

        System.out.println("25. Daemon flag -> " + daemonThread.isDaemon());

        System.out.print("26. Producer-consumer takes -> ");

        try {
            ProducerConsumer.producerConsumerDemo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        // Exceptional Handling

        System.out.print("27. Caught message for invalid list index 99 -> ");
        try {

            list.deleteAt(99);

        } catch(InvalidIndexException e) {

            System.out.println(e.getMessage());
        }

        System.out.print("28. Caught message for empty stack pop -> ");
        ArrayClaimStack arrayClaimStack = new ArrayClaimStack(5);
        try{

            arrayClaimStack.pop();

        } catch (StackEmptyException e) {

            System.out.println(e.getMessage());

        }

        System.out.print("29. Caught message for empty queue dequeue -> ");
        CircularClaimQueue circularClaimQueue1 = new CircularClaimQueue(2);
        try{

            circularClaimQueue1.dequeue();

        } catch (QueueEmptyException e) {

            System.out.println(e.getMessage());
        }

    }

}
