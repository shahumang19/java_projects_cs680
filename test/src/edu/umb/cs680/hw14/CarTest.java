package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.*;

public class CarTest {

    private String[] carToStringArray(Car car){
        String[] carString = {car.getMake(), car.getModel(), String.valueOf(car.getYear())};
        return carString;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){
        Car instance1 = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F);
        Car instance2 = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F);

        assertArrayEquals(carToStringArray(instance1), carToStringArray(instance2));
    }

    @Test
    public void verifyCarNonEqualityWithMakeModelYear(){
        String[] expected = {"Audi", "C-Class", "2018"};
        Car actual = new Car("Audi", "C-Class", 2022, 20, 38000.0F);

        assertFalse(Arrays.equals(expected, carToStringArray(actual)));
    }

    @Test
    public void verifyGetMake(){
        String expected = "Mercedes‑Benz";
        Car actual = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F);

        assertEquals(expected, actual.getMake());
    }

    @Test
    public void verifyGetModel(){
        String expected = "A-Class";
        Car actual = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F);

        assertEquals(expected, actual.getModel());
    }

    @Test
    public void verifyGetYear(){
        int expected = 2022;
        Car actual = new Car("Mercedes‑Benz", "A-Class", 2022, 25, 34000.0F);

        assertEquals(expected, actual.getYear());
    }

    @Test
    public void verifyNullValues(){
        try {
            Car instance = new Car(null, null, 2022, 25, 34000.0F);    
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);

        }
    }

    @Test
    public void verifyMileageSort(){
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
        expected.add(instance4);
        expected.add(instance3);
        expected.add(instance1);
        expected.add(instance2);

        Collections.sort(actual, Comparator.comparing(Car::getMileage));

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    public void verifyYearSort(){
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
        expected.add(instance4);
        expected.add(instance2);
        expected.add(instance3);
        expected.add(instance1);

        Collections.sort(actual, Comparator.comparing(Car::getYear));

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

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

        Collections.sort(actual, Comparator.comparing(Car::getPrice));

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void verifyEqualParetoSort(){
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

        Collections.sort(actual, Comparator.comparing(Car::getDominationCount));

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void verifyReverseMileageSort(){
        Car instance1 = new Car("x", "A-Class", 2022, 25, 34000.0F);
        Car instance2 = new Car("y", "A-Class", 2018, 40, 68000.0F);
        Car instance3 = new Car("z", "C-Class", 2021, 20, 38000.0F);
        Car instance4 = new Car("a", "Fortuner", 2015, 10, 45000.0F);

        List<Car> actual = new ArrayList<>();
        actual.add(instance1);
        actual.add(instance2);
        actual.add(instance3);
        actual.add(instance4);

        List<Car> expected = new ArrayList<>();
        expected.add(instance2);
        expected.add(instance1);
        expected.add(instance3);
        expected.add(instance4);

        Collections.sort(actual, Comparator.comparing(Car::getMileage, Comparator.reverseOrder()));

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    public void verifyReverseYearSort(){
        Car instance1 = new Car("b", "A-Class", 2022, 25, 34000.0F);
        Car instance2 = new Car("a", "A-Class", 2018, 40, 68000.0F);
        Car instance3 = new Car("z", "C-Class", 2021, 20, 38000.0F);
        Car instance4 = new Car("c", "Fortuner", 2015, 10, 45000.0F);

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

        Collections.sort(actual, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

}
