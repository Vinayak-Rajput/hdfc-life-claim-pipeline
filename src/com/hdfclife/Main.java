package com.hdfclife;

import com.hdfclife.list.ClaimLinkedList;
import com.hdfclife.list.CycleDetector;
import com.hdfclife.list.DigitListAdder;
import com.hdfclife.list.ListReverser;
import com.hdfclife.stack.ParenthesesChecker;

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

    }


}
