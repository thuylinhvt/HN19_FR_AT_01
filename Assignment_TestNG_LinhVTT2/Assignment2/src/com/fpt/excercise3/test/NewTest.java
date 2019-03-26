package com.fpt.excercise3.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.error.MarkedYAMLException;

import com.fpt.excercise3.model.MyTime;

public class NewTest {
	@Test
	public void TestContructor1() {
		MyTime myTime = new MyTime();

		Assert.assertNotNull(myTime, "Creat contructor 1 fail!");
	}

	@Test
	public void TestContructor2() {
		MyTime myTime = new MyTime(2, 3, 40);

		Assert.assertNotNull(myTime, "Creat contructor 2 fail!");
	}

	@Test
	public void TestSetTime() {
		MyTime myTime = new MyTime();
		myTime.setTime(3, 5, 10);

		MyTime myTime2 = new MyTime(3, 5, 10);
		Assert.assertEquals(myTime.equals(myTime2), true);

	}

	@Test
	public void TestGetHour() {
		MyTime myTime = new MyTime(2, 3, 40);

		Assert.assertEquals(myTime.getHour(), 2, " Method getHour() fail!");
	}

	@Test
	public void TestSetHour() {
		MyTime myTime = new MyTime(2, 3, 40);
		myTime.setHour(3);

		Assert.assertEquals(myTime.getHour(), 3, " Method setHour() fail!");
	}

	@Test
	public void TestGetMinute() {
		MyTime myTime = new MyTime(2, 3, 40);

		Assert.assertEquals(myTime.getMinute(), 3, " Method getMinute() fail!");
	}

	@Test
	public void TestSetMinute() {
		MyTime myTime = new MyTime(2, 3, 40);
		myTime.setMinute(10);

		Assert.assertEquals(myTime.getMinute(), 10, " Method setMinute() fail!");
	}
	
	@Test
	public void TestGetSecond() {
		MyTime myTime = new MyTime(2,3,40);
		
		Assert.assertEquals(myTime.getSecond(), 40, "Method getSecond() fail!");
	}
	
	@Test
	public void TestSetSecond() {
		MyTime myTime = new MyTime(2,3,40);
		myTime.setSecond(20);
		
		Assert.assertEquals(myTime.getSecond(), 20, "Method setSecond() fail!");
	}
	
	@Test
	public void TestToString() {
		MyTime myTime = new MyTime(2,3,40);
		
		Assert.assertEquals(myTime.toString(), "02:03:40", " Method toString() fail!");
	}
	
	@Test
	public void TestNextSecond() {
		MyTime myTime = new MyTime(23,59,59);
		
		Assert.assertEquals(myTime.nextSecond().toString(), "00:00:00", "Method nextSecond() fail!");
	}
	
	@Test
	public void TestNextMinute() {
		MyTime myTime = new MyTime(23,59,59);
		
		Assert.assertEquals(myTime.nextMinute().toString(), "00:00:59", "Method nextMinute() fail!");
	}
	
	@Test
	public void TestNextHour() {
		MyTime myTime = new MyTime(23,59,59);
		
		Assert.assertEquals(myTime.nextHour().toString(), "00:59:59", "Method nextHour() fail!");
	}
	
	@Test
	public void TestPreviousSecond() {
		MyTime myTime = new MyTime(0,0,0);
		
		Assert.assertEquals(myTime.previousSecond().toString(), "23:59:59", "Method previousSecond() fail!");
	}
	
	@Test
	public void TestPreviousMinute() {
		MyTime myTime = new MyTime(0,0,0);
		
		Assert.assertEquals(myTime.previousMinute().toString(), "23:59:00", "Method previousMinute() fail!");
	}
	
	@Test
	public void TestPreviousHour() {
		MyTime myTime = new MyTime(0,0,0);
		
		Assert.assertEquals(myTime.previousHour().toString(), "23:00:00", "Method previousHour() fail!");
	}
}
