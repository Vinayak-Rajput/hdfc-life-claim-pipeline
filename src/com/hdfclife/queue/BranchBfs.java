package com.hdfclife.queue;

import java.util.*;

public class BranchBfs {

    static Map<String, List<String>> adjacencyList = new HashMap<>();

    static {
        adjacencyList.put("MUMBAI", List.of("PUNE", "DELHI"));
        adjacencyList.put("PUNE", List.of("HYDERABAD"));
        adjacencyList.put("DELHI", List.of("KOLKATA"));
        adjacencyList.put("HYDERABAD", List.of("CHENNAI"));
        adjacencyList.put("KOLKATA", new ArrayList<>());
        adjacencyList.put("CHENNAI", new ArrayList<>());
    }

    public static void bfsTraversal(String city) {

        Queue<String> queue = new LinkedList<>();

        List<String> result = new ArrayList<>();

        queue.add(city);

        while(!queue.isEmpty()) {

            String currentBranch = queue.poll();
            result.add(currentBranch);

            List<String> neighbours = adjacencyList.get(currentBranch);

            if(neighbours != null) {
                for(String neighbour : neighbours) {
                    queue.add(neighbour);
                }
            }
        }

        System.out.println(String.join(" ", result));
    }
}
