package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.LinkedList;

public class PrimeGeneratorTest{

    static void addToList(LinkedList<Long> list, Long... values) {
        for (Long value : values) {
            list.addLast(value);
        }
    }

    @Test
    public void isEvenNumber0(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        assertTrue(gen.isEven(0));
    }

    @Test
    public void isEvenNumber5(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        assertFalse(gen.isEven(5L));
    }

    @Test
    public void isPrimeCheck0(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        assertFalse(gen.isPrime(0));
    }

    @Test
    public void isPrimeCheck2(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        assertTrue(gen.isPrime(2));
    }

    @Test
    public void isPrimeCheck457(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        assertTrue(gen.isPrime(457));
    }

    @Test
    public void isPrimeCheckNegative5(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        assertFalse(gen.isPrime(-5));
    }

    @Test
    public void generatePrimeCheckNull(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        assertNotNull(actual);
    }

    @Test
    public void generatePrimeFrom1to10(){
        PrimeGenerator gen = new PrimeGenerator(1L, 10L);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<Long>();
        addToList(expected, 2L,3L,5L,7L);
        assertEquals(expected, actual);
    }

    @Test
    public void generatePrimeFrom100to140(){
        PrimeGenerator gen = new PrimeGenerator(100L, 140L);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<Long>();
        addToList(expected, 101L,103L,107L,109L,113L,127L,131L,137L,139L);
        assertEquals(expected, actual);
    }

    @Test
    public void generatePrimeFrom7to11(){
        PrimeGenerator gen = new PrimeGenerator(7L, 11L);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<Long>();
        addToList(expected, 7L, 11L);
        assertEquals(expected, actual);
    }

    @Test
    public void generateEmptyPrimeList(){
        PrimeGenerator gen = new PrimeGenerator(8L, 10L);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<Long>();
        assertEquals(expected, actual);
    }

    @Test
    public void generatePrimeFrom15to30AutoBoxing(){
        Long num1 = 15L, num2 = 30L;
        PrimeGenerator gen = new PrimeGenerator(num1, num2);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<Long>();
        addToList(expected, 17L,19L,23L,29L);
        assertEquals(expected, actual);
    }

    @Test
    public void generatePrimeFrom45to85TypeCasting(){
        PrimeGenerator gen = new PrimeGenerator(45, 85L);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<Long>();
        addToList(expected, 47L,53L,59L,61L,67L,71L,73L,79L,83L);
        assertEquals(expected, actual);
    }

    @Test
    public void generatePrimeFrom50to55TypeCasting(){
        PrimeGenerator gen = new PrimeGenerator(50L, 55);
        gen.generatePrimes();
        LinkedList<Long> actual = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<Long>();
        addToList(expected, 53L);
        assertEquals(expected, actual);
    }

    @Test
    public void generatePrimeFrom0to10(){
        try {
            PrimeGenerator gen = new PrimeGenerator(0L, 10L);
            gen.generatePrimes();
            gen.getPrimes();
            fail("Generated primes from 0 to 10.");
        } catch (RuntimeException e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void generatePrimeFromNegative1to10(){
        try {
            PrimeGenerator gen = new PrimeGenerator(-1, 10L);
            gen.generatePrimes();
            gen.getPrimes();
            fail("Generated primes from -1 to 10.");
        } catch (RuntimeException e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void generatePrimeFromNegative1toNegative20(){
        try {
            PrimeGenerator gen = new PrimeGenerator(-1, -10);
            gen.generatePrimes();
            gen.getPrimes();
            fail("Generated negative primes.");
        } catch (RuntimeException e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void generatePrimeFrom10to1(){
        try {
            PrimeGenerator gen = new PrimeGenerator(10L, 1L);
            gen.generatePrimes();
            gen.getPrimes();
            fail("Generated primes from 10 to 1.");
        } catch (RuntimeException e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void generatePrimeFrom5to5(){
        try {
            PrimeGenerator gen = new PrimeGenerator(5L, 5L);
            gen.generatePrimes();
            gen.getPrimes();
            fail("Generated primes from 5 to 5.");
        } catch (RuntimeException e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

}