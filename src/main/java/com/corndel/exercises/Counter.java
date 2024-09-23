package com.corndel.exercises;

public class Counter {

    private int count;

    public Counter(int count) {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }


}
