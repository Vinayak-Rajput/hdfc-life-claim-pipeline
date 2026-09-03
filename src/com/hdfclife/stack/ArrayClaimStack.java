package com.hdfclife.stack;

import com.hdfclife.exception.StackEmptyException;
import com.hdfclife.exception.StackFullException;

public class ArrayClaimStack implements ClaimStack{

    private final int[] stack;
    private int top;

    public ArrayClaimStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    // Time Complexity: O(1)
    @Override
    public void push(int value) {
        if(top == stack.length - 1) {
            throw new StackFullException("Stack is Full, Can't Push More.");
        }
        stack[++top] = value;
    }

    // Time Complexity: O(1)
    @Override
    public int pop() {

        if(isEmpty()) {
            throw new StackEmptyException("No Elements in Stack.");
        }

        return stack[top--];
    }

    // Time Complexity: O(1)
    @Override
    public int peek() {

        if(isEmpty()) {
            throw new StackEmptyException("No Elements in Stack.");
        }

        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
