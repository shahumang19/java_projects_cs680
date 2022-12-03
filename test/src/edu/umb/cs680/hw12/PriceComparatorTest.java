package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.*;

public class PriceComparatorTest {

    @Test
    public void verifyPriceSort(){
        Car instance1 = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F);
        Car instance2 = new Car("Mercedes‑Benz", "A-Class", 2018, 40, 68000.0F);
        Car instance3 = new Car("Audi", "C-Class", 2021, 20, 38000.0F);
        Car instance4 = new Car("Toyota", "Fortuner", 2015, 10, 45000.0F);

        List<Car> actual = new ArrayList<>();
        actual.add(instance1);
        actual.add(instance2);
        actual.add(instance3);
        actual.add(instance4);

        List<Car> expected = new ArrayList<>();
        expected.add(instance1);
        expected.add(instance3);
        expected.add(instance4);
        expected.add(instance2);

        Collections.sort(actual, new PriceComparator());

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void verifyEqualPriceSort(){
        Car instance1 = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F);
        Car instance2 = new Car("Mercedes‑Benz", "A-Class", 2018, 40, 34000.0F);
        Car instance3 = new Car("Audi", "C-Class", 2021, 20, 34000.0F);
        Car instance4 = new Car("Toyota", "Fortuner", 2015, 10, 34000.0F);

        List<Car> actual = new ArrayList<>();
        actual.add(instance1);
        actual.add(instance2);
        actual.add(instance3);
        actual.add(instance4);

        List<Car> expected = new ArrayList<>();
        expected.add(instance1);
        expected.add(instance2);
        expected.add(instance3);
        expected.add(instance4);

        Collections.sort(actual, new PriceComparator());

        assertArrayEquals(expected.toArray(), actual.toArray());

    }
}
