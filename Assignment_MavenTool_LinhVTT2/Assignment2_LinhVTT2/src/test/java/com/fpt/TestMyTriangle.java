package com.fpt;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fpt.excercise3.MyPoint;
import com.fpt.excercise3.MyTriangle;

public class TestMyTriangle {

	@Test
	public void TestContructor1() {
		MyPoint myPoint1 = new MyPoint(4, 3);
		MyPoint myPoint2 = new MyPoint(2, 7);
		MyPoint myPoint3 = new MyPoint(-3, -8);
		MyTriangle myTriangle = new MyTriangle(myPoint1, myPoint2, myPoint3);

		Assert.assertNotNull(myTriangle, "Test create contructor 1 fail!");
		System.out.println("Test create contructor 1 success!");
	}

	@Test
	public void TestToString() {
		MyPoint myPoint1 = new MyPoint(4, 3);
		MyPoint myPoint2 = new MyPoint(2, 7);
		MyPoint myPoint3 = new MyPoint(-3, -8);
		MyTriangle myTriangle = new MyTriangle(myPoint1, myPoint2, myPoint3);
		
		Assert.assertEquals(myTriangle.toString(),"MyTriangle [v1=(4,3),v2=(2,7),v3=(-3,-8)]" , "Test ToString() fail!");
		System.out.println("Test toString() success!");

	}
	
	@Test
	public void TestGetPerimeter() {
		MyPoint myPoint1 = new MyPoint(4, 3);
		MyPoint myPoint2 = new MyPoint(2, 7);
		MyPoint myPoint3 = new MyPoint(-3, -8);
		MyTriangle myTriangle = new MyTriangle(myPoint1, myPoint2, myPoint3);
		
		Assert.assertEquals(myTriangle.getPerimeter(), (double)28.849793111247195, "Test getPerimeter fail!");
		System.out.println("Test getPerimeter success!");
	}
	
//	@Test
//	public void TestPrintEquilateralType() {
//	
//		int x2 = (int) (2/5);
//		int x3 = (int) (2/5);
//		int y2 = (int)(2+(3*Math.sqrt(3))/2);
//		int y3 = (int)(2-(3*Math.sqrt(3))/2);
//		MyPoint myPoint1 = new MyPoint(-2, 3);
//		MyPoint myPoint2 = new MyPoint(x2, y2);
//		MyPoint myPoint3 = new MyPoint(x3, y3);
//		MyTriangle myTriangle = new MyTriangle(myPoint1, myPoint2, myPoint3);
//		
//		Assert.assertEquals(myTriangle.printType(), "equilateral", "Test Equilateral Type fail!");
//		System.out.println("Test Equilateral Type success!");
//	}
	
	@Test
	public void TestPrintIsoscelesType() {
		MyPoint myPoint1 = new MyPoint(-1, 1);
		MyPoint myPoint2 = new MyPoint(1, 3);
		MyPoint myPoint3 = new MyPoint(2, 0);
		MyTriangle myTriangle = new MyTriangle(myPoint1, myPoint2, myPoint3);
		
		Assert.assertEquals(myTriangle.printType(), "isosceles", "Test Isosceles Type fail!");
		System.out.println("Test Isosceles Type success!");
	}
	
	@Test
	public void TestPrintScalene() {
		MyPoint myPoint1 = new MyPoint(0, 0);
		MyPoint myPoint2 = new MyPoint(0, 1);
		MyPoint myPoint3 = new MyPoint(3, 0);
		MyTriangle myTriangle = new MyTriangle(myPoint1, myPoint2, myPoint3);
		
		Assert.assertEquals(myTriangle.printType(), "scalene", "Test Scalene Type fail!");
		System.out.println("Test Scalene Type success!");
	}
}
