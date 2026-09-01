package com.hdfclife.stack;

import com.hdfclife.list.ClaimLinkedList;

import java.util.NoSuchElementException;

public class LinkedClaimStack implements ClaimStack{

    private ClaimLinkedList.ClaimNode head;
    private int size;

    public int size() {

        return size;
    }

    @Override
    public void push(int value) {

        ClaimLinkedList.ClaimNode newNode = new ClaimLinkedList.ClaimNode(value);
        newNode.next = head;
        head = newNode;

        size++;
    }

    @Override
    public int pop() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow: No Element Exist.");
        }

        int removedValue = head.amount;

        head = head.next;
        size--;

        return removedValue;
    }

    @Override
    public int peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow: No Element Exist.");
        }

        return head.amount;
    }

    @Override
    public boolean isEmpty() {

        return head == null;
    }
}
