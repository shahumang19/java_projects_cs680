package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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

}
