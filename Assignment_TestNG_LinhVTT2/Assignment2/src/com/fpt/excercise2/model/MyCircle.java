/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 6, 2019
* Version 1.0
*
*/
package com.fpt.excercise2.model;

public class MyCircle {

	private MyPoint center = new MyPoint(0,0);
	private int radius = 1;
	
	public MyCircle() {
		// TODO Auto-generated constructor stub
	}

	public MyCircle(MyPoint center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public MyCircle(int x, int y, int radius) {
		this.center = new MyPoint(x,y);
		this.radius = radius;
	}

	public MyPoint getCenter() {
		return center;
	}

	public void setCenter(MyPoint center) {
		this.center = center;
	}

	public int getCenterX() {
		return center.getX();
	}

	public int getCenterY() {
		return center.getY();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "MyCircle[radius=" + radius + ",center=(" + center.getX() + "," + center.getY() + ")]";
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	
	public double getCircumference() {
		return 2*Math.PI*radius;
	}
	
	public double distance(MyCircle another) {
		return Math.sqrt(Math.pow(center.getX()-another.getCenterX(), 2) + Math.pow(center.getY() - another.getCenterY(),2));
	}
	
	
	
	
}
