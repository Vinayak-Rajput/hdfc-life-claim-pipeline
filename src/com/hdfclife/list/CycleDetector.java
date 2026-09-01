package com.hdfclife.list;

public class CycleDetector {

    public static void hasCycle(ClaimLinkedList cll) {

        if(cll.head == null) return;

        if(cll.head.next == null) {
            System.out.println(false);
            System.out.println(cll.head.amount);
            return;
        }

        if(cll.head.next.next == null) {
            System.out.println(false);
            System.out.println(cll.head.next.amount);
            return;
        }


        ClaimLinkedList.ClaimNode slow = cll.head;
        ClaimLinkedList.ClaimNode fast = cll.head;

        boolean isCycleDetected = false;


        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                isCycleDetected = true;
                slow = cll.head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                break;
            }
        }

        System.out.println("Cycle Detected: " + isCycleDetected);

        if(isCycleDetected) {

            System.out.println("Cycle Starts at: " + slow.amount);
            return;
        }

        slow = cll.head;
        fast = cll.head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        System.out.println("Middle Value: " + slow.amount);
    }
}
