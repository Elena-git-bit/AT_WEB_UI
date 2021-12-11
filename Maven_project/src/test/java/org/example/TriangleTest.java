package org.example;


import Home_work4.FunctionTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest
{
    @Test
    @DisplayName("PositiveCase")
    void squareTriangle (){
      double result = FunctionTriangle.sTriangle(3,4,5);
        Assertions.assertEquals(result,6);
    }

    @Test
    @DisplayName("NegativeCase")
    void notSquareTriangle () {
        double result = FunctionTriangle.sTriangle(7, 4, 5);
        Assertions.assertNotEquals(result, 6);
    }
}
