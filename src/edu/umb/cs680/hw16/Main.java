package edu.umb.cs680.hw16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> p1, p2;
        p1 = Arrays.asList(2.0,3.0); 
        p2 = Arrays.asList(5.0,7.0); 
        System.out.println("Euclidean Distance : " + Distance.get(p1, p2));
        System.out.println("Manhattan Distance : " + Distance.get(p1, p2, (point1, point2)->{
            if (point1.size() == point2.size()){
                double sum = 0.0;
                for(int i=0; i < point1.size(); i++) {
                    sum += Math.abs(point1.get(i)-point2.get(i));
                }
                return sum;	
            }else{
                throw new RuntimeException("Invalid point size!!!");
            }
        }));

        System.out.println("Chebyshev Distance : " + Distance.get(p1, p2, (point1, point2)->{
            double max=0;
            if (point1.size() == point2.size()){
                double value = 0.0;
                for(int i=0; i < point1.size(); i++) {
                    value = Math.abs(point1.get(i)-point2.get(i));
                    if (value > max){
                        max = value;
                    }
                }
                return max;	
            }else{
                throw new RuntimeException("Invalid point size!!!");
            }
                
        }));
        
        List<List<Double>> points = new ArrayList<>(); 
        points.add(p1); 
        points.add(p2); 
        System.out.println("Euclidean Distance Matrix : " + Distance.matrix(points));

        System.out.println("Manhattan Distance Matrix : " + Distance.matrix(points, (point1, point2)->{
            if (point1.size() == point2.size()){
                double sum = 0.0;
                for(int i=0; i < point1.size(); i++) {
                    sum += Math.abs(point1.get(i)-point2.get(i));
                }
                return sum;	
            }else{
                throw new RuntimeException("Invalid point size!!!");
            }
        }));

        System.out.println("Chebyshev Distance Matrix : " + Distance.matrix(points, (point1, point2)->{
            double max=0;
            if (point1.size() == point2.size()){
                double value = 0.0;
                for(int i=0; i < point1.size(); i++) {
                    value = Math.abs(point1.get(i)-point2.get(i));
                    if (value > max){
                        max = value;
                    }
                }
                return max;	
            }else{
                throw new RuntimeException("Invalid point size!!!");
            }
                
        }));
    }
}
