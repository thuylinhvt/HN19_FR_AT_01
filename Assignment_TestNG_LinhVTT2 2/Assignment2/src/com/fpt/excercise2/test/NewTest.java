package com.fpt.excercise2.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fpt.excercise2.model.MyCircle;
import com.fpt.excercise2.model.MyPoint;

public class NewTest {
  @Test
  public void TestContructor1() {
	  MyCircle myCircle = new MyCircle();
	  
	  Assert.assertNotNull(myCircle, "Creat contructor 1 fail!");
  }
  
  @Test
  public void TestContructor2() {
	  MyCircle myCircle  = new MyCircle(1,1,2);
	  
	  Assert.assertNotNull(myCircle, "Creat contructor 2 fail!");
  }
  
  @Test
  public void TestContructor3() {
	  MyPoint myPoint = new MyPoint(1,2);
	  MyCircle myCircle = new MyCircle(myPoint, 3);
	  
	  Assert.assertNotNull(myCircle, "Creat contructor 3 fail!");
  }
  
  @Test
  public void TestGetRadius() {
	  MyCircle myCircle  = new MyCircle(1,1,2);
	  
	  Assert.assertEquals(myCircle.getRadius(),2, " Method get radius() fail!");
  }
  
  @Test
  public void TestSetRadius() {
	  MyCircle myCircle  = new MyCircle(1,1,2);
	  myCircle.setRadius(4);
	  
	  Assert.assertEquals(myCircle.getRadius(), 4, " Method setRadius() fail!");
  }
  
  @Test
  public void TestGetCenter() {
	  MyPoint myPoint = new MyPoint(1,2);
	  MyCircle myCircle = new MyCircle(myPoint, 3);
	  
	  Assert.assertEquals(myCircle.getCenter(), myPoint, " Method getCenter() fail!");
  }
  
  @Test
  public void TestSetCenter() {
	  MyPoint myPoint = new MyPoint(1,2);
	  MyPoint center = new MyPoint(2,2);
	  MyCircle myCircle = new MyCircle(myPoint, 3);
	  myCircle.setCenter(center);
	  
	  Assert.assertEquals(myCircle.getCenter(), center, "Method setCenter() fail!");
	  
  }
  
  @Test
  public void TestGetCenterX() {
	  MyPoint center = new MyPoint(2,2);
	  MyCircle myCircle = new MyCircle(center, 3);
	  
	  Assert.assertEquals(myCircle.getCenterX(), center.getX(), "Method getCenterX() fail!)");
  }
  
  @Test
  public void TestGetCenterY() {
	  MyPoint center = new MyPoint(2,2);
	  MyCircle myCircle = new MyCircle(center, 3);
	  
	  Assert.assertEquals(myCircle.getCenterY(), center.getY(), "Method getCenterY() fail!)");
  }
  
  @Test
  public void TestToString() {
	  MyPoint center = new MyPoint(2,2);
	  MyCircle myCircle = new MyCircle(center, 3);
	  
	  Assert.assertEquals(myCircle.toString(), "MyCircle[radius=3,center=(2,2)]", "Method toString() fail!");
  }
  
  @Test
  public void TestGetArea() {
	  MyPoint center = new MyPoint(2,2);
	  MyCircle myCircle = new MyCircle(center, 3);
	  
	  Assert.assertEquals(myCircle.getArea(), 28.274333882308138, "Method getArea() fail!");
  }
  
  @Test
  public void TestGetCircumference() {
	  MyPoint center = new MyPoint(2,2);
	  MyCircle myCircle = new MyCircle(center, 3);
	  
	  Assert.assertEquals(myCircle.getCircumference(), 18.84955592153876, "Method getCircumference() fail! ");
  }
  
  @Test
  public void TestDistance() {
	  MyPoint center = new MyPoint(2,2);
	  MyCircle myCircle = new MyCircle(center, 3);
	  
	  MyPoint myPoint = new MyPoint(3,3);
	  MyCircle another = new MyCircle(myPoint,5);
	  
	  
	  Assert.assertEquals(myCircle.distance(another), 1.4142135623730951, "Method distance fail!");
  }
}
