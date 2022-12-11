package edu.umb.cs680.hw16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distance {
	public static double get(List<Double> p1, List<Double> p2) {
		return Distance.get(p1, p2, (point1, point2)->{
			if (point1.size() == point2.size()){
				double sumOfSquared = 0.0;
				for(int i=0; i < point1.size(); i++) {
					sumOfSquared += Math.pow( point1.get(i)-point2.get(i), 2 );
				}
				return Math.sqrt(sumOfSquared);	
			}else{
				throw new RuntimeException("Invalid point size!!!");
			}	
		});
	}
	
	public static double get(List<Double> p1, List<Double> p2, DistanceMetric metric) {
		return metric.distance(p1, p2);
	}
	
	public static List<List<Double>> matrix(List<List<Double>> points) {
			return Distance.matrix(points, (point1, point2)->{
				if (point1.size() == point2.size()){
					double sumOfSquared = 0.0;
					for(int i=0; i < point1.size(); i++) {
						sumOfSquared += Math.pow( point1.get(i)-point2.get(i), 2 );
					}
					return Math.sqrt(sumOfSquared);	
				}else{
					throw new RuntimeException("Invalid point size!!!");
				}	
			});
	}; 
	
	public static List<List<Double>> matrix(List<List<Double>> points, DistanceMetric metric) {
		// This method is not that efficient; there is a room for performance
		// improvement by, for example, taking advantage of the symmetric nature
		// of a distance matrix. But, let's not worry about that here.   
		int numOfPoints = points.size();
		List<List<Double>> distanceMatrix = Distance.initDistanceMatrix(numOfPoints);
		List<Double> current, peer;

		for(int i=0; i < numOfPoints; i++) {
			current = points.get(i);
			for(int j=0; j < numOfPoints; j++) {
				peer = points.get(j);
				double distance = Distance.get(current, peer, metric);
				distanceMatrix.get(i).set(j, distance);
			}
		}
		return distanceMatrix;
	}
	
	private static List<List<Double>> initDistanceMatrix(int numOfPoints){
		List<List<Double>> distanceMatrix = new ArrayList<>(numOfPoints);
		for(int i=0; i < numOfPoints; i++) {
			Double[] vector = new Double[numOfPoints];
			Arrays.fill(vector, 0.0);
			distanceMatrix.add( Arrays.asList(vector) );
		}
		return distanceMatrix;
	}

}
