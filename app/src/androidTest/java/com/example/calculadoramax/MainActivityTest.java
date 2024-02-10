package com.example.calculadoramax;

import junit.framework.TestCase;

public class MainActivityTest extends TestCase {
    public void testFactorial() {
        assertEquals(120, MainActivity.factorial(5));
    }

    public void testFibonacci() {
        assertEquals(21, MainActivity.fibonacci(8));
    }
    public void testSuma() {
        assertEquals(5, MainActivity.suma(2, 3), 0.1);
    }
    public void testResta() {
        assertEquals(3, MainActivity.resta(5, 2), 0.1);
    }

    public void testMultiplicacion() {
        assertEquals(6, MainActivity.multiplicacion(2, 3), 0.1);
    }
    public void testDivision() {
        assertEquals(2, MainActivity.division(6, 3), 0.1);
        assertEquals(Double.NaN, MainActivity.division(6, 0), 0.1);
    }
}
