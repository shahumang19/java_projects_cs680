package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.*;

public class ParetoComparatorTest {
    @Test
    public void verifyPriceSort(){
        Car instance1 = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F); // 0 
        Car instance2 = new Car("Mercedes‑Benz", "A-Class", 2018, 15, 68000.0F); // 2 (1, 4)
        Car instance3 = new Car("Audi", "C-Class", 2021, 20, 38000.0F);          // 1 (1)
        Car instance4 = new Car("Toyota", "Fortuner", 2015, 10, 69000.0F);       // 3 (1,2,3)

        List<Car> actual = new ArrayList<>();
        actual.add(instance1);
        actual.add(instance2);
        actual.add(instance3);
        actual.add(instance4);

        List<Car> expected = new ArrayList<>();
        expected.add(instance1);
        expected.add(instance3);
        expected.add(instance2);
        expected.add(instance4);

        for(Car car: actual){
            car.setDominationCount(actual); 
        }

        Collections.sort(actual, new ParetoComparator());

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void verifyEqualPriceSort(){
        // Test to ensure the below condition
        // A’s objective values are superior than B’s in at least one objective.

        Car instance1 = new Car("Mercedes‑Benz", "A-Class", 2022, 17, 34000.0F);
        Car instance2 = new Car("Mercedes‑Benz", "A-Class", 2022, 17, 34000.0F);
        Car instance3 = new Car("Audi", "C-Class", 2022, 17, 34000.0F);
        Car instance4 = new Car("Toyota", "Fortuner", 2022, 17, 34000.0F);

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

        for(Car car: actual){
            car.setDominationCount(actual);
        }

        Collections.sort(actual, new ParetoComparator());

        assertArrayEquals(expected.toArray(), actual.toArray());

    }
}
