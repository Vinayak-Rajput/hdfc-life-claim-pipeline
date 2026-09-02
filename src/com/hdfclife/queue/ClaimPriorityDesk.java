package com.hdfclife.queue;

import com.hdfclife.model.Claim;

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.hdfclife.model.Urgency.*;

public class ClaimPriorityDesk {

    static PriorityQueue<Claim> priorityQueue = new PriorityQueue<>
            (Comparator.comparing(Claim::getUrgency)
                    .thenComparing(Comparator.comparing(Claim::getClaimAmount).reversed()));

    static {
        priorityQueue.add(new Claim("CLM-01", 25000, "HDFC-LIFE-1001", "Anita Sharma", HIGH));
        priorityQueue.add(new Claim("CLM-02", 18000, "HDFC-LIFE-1002", "Rahul Mehta", MEDIUM));
        priorityQueue.add(new Claim("CLM-03", 42000, "HDFC-LIFE-1005", "Sneha Patel", HIGH));
        priorityQueue.add(new Claim("CLM-04", 15000, "HDFC-LIFE-1004", "Vikram Singh", LOW));
        priorityQueue.add(new Claim("CLM-05", 31000, "HDFC-LIFE-1001", "Anita Sharma", MEDIUM));
        priorityQueue.add(new Claim("CLM-06", 9000, "HDFC-LIFE-1003", "Priya Nair", LOW));
    }

    public static void printClaimsPQ() {

        PriorityQueue<Claim> copy = new PriorityQueue<>(priorityQueue);

        while(!copy.isEmpty()) {
            System.out.print(copy.poll().getClaimId() + " ");
        }
        System.out.println();
    }
}
