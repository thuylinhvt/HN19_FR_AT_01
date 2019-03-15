package com.fpt.excercise3;

public class MyPoint {

	private int x;
	private int y;
	
	public MyPoint() {
	}

	public MyPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public double distances(MyPoint myPoint1) {
		double distance = Math.sqrt(Math.pow((x-myPoint1.getX()), 2) + Math.pow((y-myPoint1.getY()), 2));
		return distance;
	}
}
