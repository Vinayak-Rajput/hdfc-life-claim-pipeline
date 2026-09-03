package com.hdfclife.list;

public class DigitListAdder {

    // Time Complexity: O(max(m,n)); Space Complexity: O(max(m,n))
    public static ClaimLinkedList sumList( ClaimLinkedList cll1, ClaimLinkedList cll2) {

        ClaimLinkedList sum = new ClaimLinkedList();

        ClaimLinkedList.ClaimNode num1 = cll1.head;
        ClaimLinkedList.ClaimNode num2 = cll2.head;

        int carry = 0;

        while(num1 != null || num2 != null || carry != 0) {

            int localSum = 0;

            if(num1!=null) {
                localSum +=  num1.amount;
                num1 =  num1.next;
            }

            if(num2!=null) {
                localSum += num2.amount;
                num2  = num2.next;
            }

            localSum += carry;

            carry = localSum / 10;

            sum.addLast(localSum % 10);
        }

        return sum;
    }
}
