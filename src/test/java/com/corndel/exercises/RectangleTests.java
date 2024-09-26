package com.corndel.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {

    @Test
    public void RectangleAreaTest() {
        // Arrange
        Rectangle rectangle = new Rectangle(20, 10);

        // Act
        double result = rectangle.getArea();

        // Assert
        assertEquals(200, result, "Area should be 200");
    }

    @Test
    public void RectanglePerimeterTest() {
        // Arrange
        Rectangle rectangle = new Rectangle(20, 10);

        // Act
        double result = rectangle.getPerimeter();

        // Assert
        assertEquals(60, result, "Perimeter should be 60");
    }

}
