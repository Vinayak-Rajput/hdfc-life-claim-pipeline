package com.hdfclife.list;

public class CycleDetector {

    // Time Complexity: O(n); Space Complexity: O(1)
    public static int hasCycle(ClaimLinkedList cll) {

        if(cll.head == null) return -1;

        if(cll.head.next == null) {
            System.out.println(false);
            return -1;
        }

        if(cll.head.next.next == null) {
            System.out.println(false);
            return -1;
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

        System.out.println(isCycleDetected);
        return slow.amount;

    }

    // Time Complexity: O(n); Space Complexity: O(1)
    public static void middleValue(ClaimLinkedList cll) {

        ClaimLinkedList.ClaimNode slow = cll.head;
        ClaimLinkedList.ClaimNode fast = cll.head;

        slow = cll.head;
        fast = cll.head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        System.out.println(slow.amount);

    }
}
