package com.corndel.exercises;

public class Counter {

    int count;

    public Counter() {
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
