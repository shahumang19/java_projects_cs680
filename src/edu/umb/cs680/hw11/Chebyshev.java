package edu.umb.cs680.hw11;

import java.util.List;

public class Chebyshev implements DistanceMetric{
	public double distance(List<Double> p1, List<Double> p2) {
		double max=0;
		if (p1.size() == p2.size()){
			double value = 0.0;
			for(int i=0; i < p1.size(); i++) {
				value = Math.abs(p1.get(i)-p2.get(i));
				if (value > max){
					max = value;
				}
			}
			return max;	
		}else{
			throw new RuntimeException("Invalid point size!!!");
		}
			
	}
}
