package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

public class DistanceTest {

    @Test
    public void verifyEuclideanDistance2D(){
        List<Double> p1, p2;
        p1 = Arrays.asList(33.0,21.0); 
        p2 = Arrays.asList(67.0,89.0); 
        assertEquals(76.02631123499285, Distance.get(p1, p2));
    }

    @Test
    public void verifyManhattanDistance2D(){
        List<Double> p1, p2;
        p1 = Arrays.asList(55.0,-4.0); 
        p2 = Arrays.asList(89.0,324.0); 
        assertEquals(362.0, Distance.get(p1, p2, new Manhattan()));
    }

    @Test
    public void verifyChebyshevDistance2D(){
        List<Double> p1, p2;
        p1 = Arrays.asList(-95.0,-9.0); 
        p2 = Arrays.asList(3.0,23.0); 
        assertEquals(98.0, Distance.get(p1, p2, new Chebyshev()));
    }

    @Test
    public void verifyEuclideanDistanceMatrix3D(){
        List<List<Double>> expected = new ArrayList<>(); 
        expected.add(Arrays.asList(0.0, 19.05255888325765, 14.0, 47.50789408087881, 28.071337695236398));
        expected.add(Arrays.asList(19.05255888325765, 0.0, 29.444863728670914, 35.749125863438955, 43.57751713900185)); 
        expected.add(Arrays.asList(14.0, 29.444863728670914, 0.0, 55.39855593785816, 17.663521732655695));
        expected.add(Arrays.asList(47.50789408087881, 35.749125863438955, 55.39855593785816, 0.0, 72.80796659706958));
        expected.add(Arrays.asList(28.071337695236398, 43.57751713900185, 17.663521732655695, 72.80796659706958, 0.0));

        List<List<Double>> points = new ArrayList<>(); 
        points.add(Arrays.asList( 1.0, 2.0, 3.0)); 
        points.add(Arrays.asList( 12.0, 13.0, 14.0));
        points.add(Arrays.asList( 1.0, -12.0, 3.0));
        points.add(Arrays.asList( -2.0, 24.0, 45.0));
        points.add(Arrays.asList( 5.0, -22.0, -11.0));

        assertTrue(Arrays.deepEquals(expected.toArray(), Distance.matrix(points).toArray()));
    }

    @Test
    public void verifyManhattanDistanceMatrix3D(){
        List<List<Double>> expected = new ArrayList<>(); 
        expected.add(Arrays.asList(0.0, 9.0, 22.0, 29.0, 42.0, 35.0));
        expected.add(Arrays.asList(9.0, 0.0, 19.0, 26.0, 39.0, 38.0)); 
        expected.add(Arrays.asList(22.0, 19.0, 0.0, 39.0, 52.0, 43.0));
        expected.add(Arrays.asList(29.0, 26.0, 39.0, 0.0, 53.0, 64.0));
        expected.add(Arrays.asList(42.0, 39.0, 52.0, 53.0, 0.0, 51.0));
        expected.add(Arrays.asList(35.0, 38.0, 43.0, 64.0, 51.0, 0.0));

        List<List<Double>> points = new ArrayList<>(); 
        points.add(Arrays.asList( 1.0, 2.0, 3.0)); 
        points.add(Arrays.asList( 4.0, 5.0, 6.0));
        points.add(Arrays.asList( 7.0, -8.0, 9.0));
        points.add(Arrays.asList( -10.0, 11.0, 12.0));
        points.add(Arrays.asList( 13.0, 14.0, -15.0));
        points.add(Arrays.asList( 34.0, 1.0, 2.0));

        assertTrue(Arrays.deepEquals(expected.toArray(), Distance.matrix(points, new Manhattan()).toArray()));
    }

    @Test
    public void verifyChebyshevDistanceMatrix3D(){
        List<List<Double>> expected = new ArrayList<>(); 
        expected.add(Arrays.asList(0.0, 61.0, 10.5, 111.0, 18.0));
        expected.add(Arrays.asList(61.0, 0.0, 55.0, 103.0, 79.0)); 
        expected.add(Arrays.asList(10.5, 55.0, 0.0, 106.2, 24.0));
        expected.add(Arrays.asList(111.0, 103.0, 106.2, 0.0, 112.0));
        expected.add(Arrays.asList(18.0, 79.0, 24.0, 112.0, 0.0));

        List<List<Double>> points = new ArrayList<>(); 
        points.add(Arrays.asList( 12.0, 2.0, 3.0)); 
        points.add(Arrays.asList( 4.0, 5.0, 64.0));
        points.add(Arrays.asList( 7.2, -8.5, 9.0));
        points.add(Arrays.asList( -99.0, 11.0, 22.0));
        points.add(Arrays.asList( 13.0, 14.0, -15.0));

        assertTrue(Arrays.deepEquals(expected.toArray(), Distance.matrix(points, new Chebyshev()).toArray()));
    }

    @Test
    public void verifyUnEqualPointSize(){
        try {
            List<Double> p1, p2;
            p1 = Arrays.asList(33.0); 
            p2 = Arrays.asList(67.0,89.0); 
            Distance.get(p1, p2);
            fail("Distance Calculation works with unequal point sizes!!!");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void verifyUnEqualPointSizeWithMatrix(){
        try {
            List<Double> p1, p2;
            List<List<Double>> points = new ArrayList<>(); 
            p1 = Arrays.asList(33.0); 
            p2 = Arrays.asList(67.0,89.0); 
            points.add(p1); 
            points.add(p2);

            Distance.matrix(points);
            fail("Distance Calculation works with unequal point sizes!!!");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }
}
