package fa.edu.excercise1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise1 {
	@BeforeSuite
	public void setupSuite() {
		System.out.println("@BeforeSuite started.");
	}
	
	@BeforeTest
	public void setupTests() {
		System.out.println("@BeforeTest started.");
	}
	
	@BeforeClass
	public void setupClass() {
		System.out.println("@BeforeClass started.");
	}
	
	@BeforeMethod
	public void setupTest() {
		System.out.println("@BeforeMethod has started.");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("@Test method 1 has started.");
	}

	@Test
	public void TestCase2() {
		System.out.println("@Test method 2 has started.");
	}

	@AfterMethod
	public void teardownTest() {
		System.out.println("@AfterMethod has started.");
	}

	@AfterClass
	public void teardownClass() {
		System.out.println("@AfterClass has started.");
	}
	
	@AfterTest
	public void teardownTests() {
		System.out.println("@AfterTest has started.");
	}
	
	@AfterSuite
	public void teartdownSuite() {
		System.out.println("@AfterSuite has started");
	}

 
  
}
