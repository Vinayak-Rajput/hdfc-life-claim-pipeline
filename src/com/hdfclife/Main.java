package com.hdfclife;

import com.hdfclife.list.ClaimLinkedList;

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
    }


}
