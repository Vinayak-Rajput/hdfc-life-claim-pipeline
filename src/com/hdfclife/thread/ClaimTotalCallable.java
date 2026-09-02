package com.hdfclife.thread;

import java.util.List;
import java.util.concurrent.Callable;

public class ClaimTotalCallable implements Callable<Integer> {

    private List<Integer> seeds;

    public ClaimTotalCallable(List<Integer> seeds) {
        this.seeds = seeds;
    }

    @Override
    public Integer call() throws Exception {

        int sum = 0;

        for(int seed: seeds) {
            sum += seed;
        }

        return sum;
    }
}
