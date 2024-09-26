package com.corndel.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {

    @Test
    public void checkPIValue() {
        double PI = 3.14;
        assertEquals(PI, Maths.PI);
    }

    @Test
    public void checkMaxValue() {
        assertEquals(20, Math.max(20, 5));
        assertEquals(10, Math.max(4, 10));
        assertEquals(500, Math.max(20, 500));

    }
}
