package com.meschac.mafoula;

public class Question15 implements Math  {
		
		@Override
		public double add(double ... n){
			double sum = 0; //Initialized to suppress warnings
			for (int i=0; i<n.length; i++) {
				sum += n[i];
			}
			return sum;
		}

		@Override
		public double subtract(double... n) {
			double diff = n[0]; //Initialized to first value in array
			for (int i=1; i<n.length; i++) { //start from the second value in the array
				diff -= n[i];
			}
			return diff;
		}

		@Override
		public double multiply(double... n) {
			double product=1; //Init to 1 so it won't always return 0
			for (int i=0; i<n.length; i++) {
				product *= n[i];
			}
			return product;
		}

		@Override
		public double divide(double a, double b) {
			return a/b;
		}
	}
	//COMPLETED

	
		
