package com.fpt.excercise3;

public class MyTriangle {

	private MyPoint v1;
	private MyPoint v2;
	private MyPoint v3;

	public MyTriangle() {
		// TODO Auto-generated constructor stub
	}

	public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
		if (v1.distances(v2) + v2.distances(v3) < v3.distances(v1) || v1.distances(v3) + v3.distances(v2) < v2.distances(v1)
				|| v2.distances(v3) + v3.distances(v1) < v1.distances(v2)) {
			throw new IllegalArgumentException("Not a triangle!");
		} else {
			this.v1 = v1;
			this.v2 = v2;
			this.v3 = v3;
		}
	}

	public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {

	
		if (v1.distances(v2) + v2.distances(v3) < v3.distances(v1) || v1.distances(v3) + v3.distances(v2) < v2.distances(v1)
				|| v2.distances(v3) + v3.distances(v1) < v1.distances(v2)) {
			throw new IllegalArgumentException("Not a triangle!");
		} else {
			this.v1 = new MyPoint(x1, y2);
			this.v2 = new MyPoint(x2, y2);
			this.v3 = new MyPoint(x3, y3);
		}
	}

	public MyPoint getV1() {
		return v1;
	}

	public void setV1(MyPoint v1) {
		this.v1 = v1;
	}

	public MyPoint getV2() {
		return v2;
	}

	public void setV2(MyPoint v2) {
		this.v2 = v2;
	}

	public MyPoint getV3() {
		return v3;
	}

	public void setV3(MyPoint v3) {
		this.v3 = v3;
	}

	public double getPerimeter() {
		double p = v1.distances(v1) + v2.distances(v3) + v3.distances(v1);
		return p;
	}

	public String printType() {
		if (v1.distances(v2) == v2.distances(v3) && v1.distances(v3) == v3.distances(v2)) {
			return "equilateral";
		} else if (v1.distances(v2) == v2.distances(v3) || v1.distances(v3) == v3.distances(v2)
				|| v2.distances(v3) == v3.distances(v1)) {
			return "isosceles";
		} else
			return "scalene";
	}

	@Override
	public String toString() {
		return "MyTriangle [v1=(" + v1.getX() + "," + v1.getY() + "),v2=(" + v2.getX() + "," + v2.getY() + "),v3=("
				+ v3.getX() + "," + v3.getY() + ")]";
	}

}
