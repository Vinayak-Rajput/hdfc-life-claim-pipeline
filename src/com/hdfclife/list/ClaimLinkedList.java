package com.hdfclife.list;

import com.hdfclife.exception.EmptyListException;
import com.hdfclife.exception.InvalidIndexException;

public class ClaimLinkedList {

    int size;
    ClaimNode head;
    ClaimNode tail;

    public static class ClaimNode {
        public int  amount;
        public ClaimNode next;

        public ClaimNode(int amount){
            this.amount = amount;
        }
    }

    public ClaimNode getHead() {
        return head;
    }

    public ClaimNode getTail() {
        return tail;
    }

    public void addFirst(int amount) {

        ClaimNode newNode = new ClaimNode(amount);

        if(head == null) {

            head = tail = newNode;

        } else {

            newNode.next = head;
            head = newNode;

        }

        size++;

    }

    public void addLast(int amount) {

        ClaimNode newNode = new ClaimNode(amount);

        if(head == null) {

            head = tail = newNode;

        } else {

            tail.next = newNode;
            tail = newNode;

        }

        size++;

    }

    // Time Complexity: O(n); Space Complexity: O(1)
    public void insertAt(int index, int amount) {

        if(index < 0 || index > size) {

            throw new InvalidIndexException("Invalid Index.");
        }

        if(index == 0) {

            addFirst(amount);
            return;

        }

        if (index == size) {

            addLast(amount);
            return;

        }

        ClaimNode newNode = new ClaimNode(amount);
        ClaimNode temp = head;

        for(int i = 0; i < index-1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    // Time Complexity: O(n); Space Complexity: O(1)
    public void deleteAt(int index) {

        if(head == null) {
            throw new EmptyListException("No Element to delete.");
        }

        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid Index.");
        }

        if(index == 0) {

            head = head.next;
            size--;
            return;

        }

        if (index == size - 1){

            ClaimNode temp = head;

            while(temp.next.next != null) { // current.next != tail
                temp = temp.next;
            }

            tail = temp;
            temp.next = null;

            size--;
            return;
        }

        ClaimNode temp = head;

        for(int i = 0; i < index-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        size --;
    }

    public ClaimNode nodeAt(int index) {

        if(index < 0 || index > size){

            throw new InvalidIndexException("Invalid Index.");
        }

        ClaimNode temp = head;

        for(int i=0; i<index; i++) {

            temp = temp.next;
        }

        return temp;
    }

    public void toArray() {

        ClaimNode node = head;

        while(node != null) {

            System.out.print(node.amount);

            if(node.next != null) System.out.print(", ");
            node = node.next;

        }

        System.out.println();
    }

    public int size(){
        return size;
    }

    public ClaimLinkedList cloneList() {
        ClaimLinkedList cllClone = new ClaimLinkedList();

        ClaimNode temp = this.head;

        while(temp != null) {

            cllClone.addLast(temp.amount);
            temp = temp.next;

        }

        return cllClone;
    }

}
