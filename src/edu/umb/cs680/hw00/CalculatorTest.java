package edu.umb.cs680.hw00;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Random;

public class CalculatorTest{

    Calculator cut;

    @BeforeEach                                         
    void setUp() {
        cut = new Calculator();
    }

    @Test
    public void multiply3by4(){
        float actual = cut.multiply(3,4);
        float expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    public void multiply10by2(){
        float expected = 20.0f;
        float actual = cut.multiply(10.0f, 2.0f);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyNegative10by2(){
        float expected = -20.0f;
        float actual = cut.multiply(-10.0f, 2.0f);
        assertEquals(expected, actual);
    }

    @Test
    public void multiply10byNegative2(){
        float expected = -20.0f;
        float actual = cut.multiply(10.0f, -2.0f);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyNegative10byNegative2(){
        float expected = 20.0f;
        float actual = cut.multiply(-10.0f, -2.0f);
        assertEquals(expected, actual);
    }

    @Test
    public void multiply0by2(){
        float expected = 0f;
        float actual = cut.multiply(0, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void multiply10by0(){
        float expected = 0f;
        float actual = cut.multiply(10, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void divide3by2(){
        float actual = cut.divide(3,2);
        float expected = 1.5f;
        assertEquals(expected, actual);
    }

    @Test
    public void divide4by0(){
        try {
            // Calculator cut = new Calculator();
            cut.divide(4, 0);
            fail("Division by Zero");
        } catch (IllegalArgumentException e) {
            assertEquals("division by zero", e.getMessage() );
        }
    }

    @Test
    public void divide10by5AutoUnBoxing(){
        Integer num1 = 10, num2 = 5;
        float expected = 2.0f;
        float actual = cut.divide(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void divide0by2(){
        float expected = 0;
        float actual = cut.divide(0, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void divideNegative300by2(){
        float expected = -150.0f;
        float actual = cut.divide(-300.0f, 2.0f);
        assertEquals(expected, actual);
    }

    @Test
    public void divide300byNegative2(){
        float expected = -150.0f;
        float actual = cut.divide(300.0f, -2.0f);
        assertEquals(expected, actual);
    }

    @Test
    public void divideNegative300byNegative2(){
        float expected = 150.0f;
        float actual = cut.divide(-300.0f, -2.0f);
        assertEquals(expected, actual);
    }
    

    @RepeatedTest(10)
    public void multiplyCheckNullInteger(){
        Random rand = new Random();
        Integer randInt1 = rand.nextInt(50000);
        Integer randInt2 = rand.nextInt(50000);

        float result = cut.multiply(randInt1, randInt2);

        assertNotNull(result);
    }

    @RepeatedTest(10)
    public void multiplyCheckNullFloat(){
        Random rand = new Random();
        Float randFloat1 = rand.nextFloat();
        Float randFloat2 = rand.nextFloat();

        float result = cut.multiply(randFloat1, randFloat2);

        assertNotNull(result);
    }

    @RepeatedTest(10)
    public void divideCheckNullInteger(){
        Random rand = new Random();
        Integer randInt1 = rand.nextInt(50000);
        Integer randInt2 = rand.nextInt(50000);

        // Ensuring division by value greater than 0
        randInt2 = randInt2 + 1;

        float result = cut.divide(randInt1, randInt2);

        assertNotNull(result);
    }

    @RepeatedTest(10)
    public void divisionCheckNullFloat(){
        Random rand = new Random();
        Float randFloat1 = rand.nextFloat();
        Float randFloat2 = rand.nextFloat();

        // Ensuring division by value greater than 0
        randFloat2 = randFloat2 + 0.1f;

        float result = cut.divide(randFloat1, randFloat2);

        assertNotNull(result);
    }
}