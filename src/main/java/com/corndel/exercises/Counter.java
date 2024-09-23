package com.corndel.exercises;

public class Counter {

    private int count;

    public Counter() {
        this.count = 0;
    }

    public Counter(int initialCount) {
        this.count = initialCount;
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
