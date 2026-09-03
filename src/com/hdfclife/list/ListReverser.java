package com.hdfclife.list;

public class ListReverser {

    // Time Complexity: O(n); Space Complexity: O(1)
    public static void iterativeReverse(ClaimLinkedList cll) {

        ClaimLinkedList.ClaimNode current =  cll.head;
        ClaimLinkedList.ClaimNode prev = null;
        ClaimLinkedList.ClaimNode next;

        while(current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        while(prev != null) {

            System.out.print(prev.amount + " ");
            prev = prev.next;

        }

        System.out.println();
    }

    // Time Complexity: O(n); Space Complexity: O(n)
    public static void recursiveReverse(ClaimLinkedList list){

        ClaimLinkedList.ClaimNode newHead = reverse(list.head);

        while (newHead != null) {
            System.out.print(newHead.amount + " ");
            newHead = newHead.next;
        }

        System.out.println();
    }

    public static ClaimLinkedList.ClaimNode reverse(ClaimLinkedList.ClaimNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ClaimLinkedList.ClaimNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
