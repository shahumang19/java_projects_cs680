package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> p1, p2;
        p1 = Arrays.asList(2.0,3.0); 
        p2 = Arrays.asList(5.0,7.0); 
        System.out.println("Euclidean Distance : " + Distance.get(p1, p2));
        System.out.println("Manhattan Distance : " + Distance.get(p1, p2, new Manhattan()));
        System.out.println("Chebyshev Distance : " + Distance.get(p1, p2, new Chebyshev()));
        
        List<List<Double>> points = new ArrayList<>(); 
        points.add(p1); 
        points.add(p2); 
        System.out.println("Euclidean Distance Matrix : " + Distance.matrix(points));
        System.out.println("Manhattan Distance Matrix : " + Distance.matrix(points, new Manhattan()));
        System.out.println("Chebyshev Distance Matrix : " + Distance.matrix(points, new Chebyshev()));
    }
}
