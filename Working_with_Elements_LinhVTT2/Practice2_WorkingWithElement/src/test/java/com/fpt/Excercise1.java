package com.fpt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Excercise1 {
  private WebDriver driver;
  
  @BeforeClass
  
  public void setup() {
	  System.setProperty("webdriver.chrome.driver","chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
  }
  
  @Test(priority = 0)
  public void TestTitle() {
	  String expectedResult = "My Store";
	  String actualResult = driver.getTitle();
	  if(actualResult.equals(expectedResult)) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @Test(priority = 1)
  public void TestLogo() {
	  WebElement logo = driver.findElement(By.xpath("//*[@id='header_logo']//img"));
	 if(logo.isDisplayed()) {
		 System.out.println("PASS");
	 }else {
		 System.out.println("FAIL");
	 }
  }
  
  @Test(priority = 2)
  public void TestTextSearchBox() {
	  WebElement textSearchbox = driver.findElement(By.id("search_query_top"));
	  if(textSearchbox.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  
  @Test(priority=3)
  public void TestBtnSearchBox() {
	  WebElement btnSearchbox = driver.findElement(By.xpath("//*[@id='searchbox']//button"));
	  if(btnSearchbox.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @Test(priority=4)
  public void TestCart() {
	  WebElement cart = driver.findElement(By.xpath("//*[@title='View my shopping cart']"));
	  if(cart.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @Test(priority=5)
  public void TestWomenItem() {
	  WebElement womenItem = driver.findElement(By.xpath("//*[@title='Women']"));
	  if(womenItem.isDisplayed()){
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @Test(priority=6)
  public void TestDressItem() {
	  WebElement dressItem = driver.findElement(By.xpath("//*[@title='Dresses']"));
	  if(dressItem.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @Test(priority=7)
  public void TestTshirt() {
	  WebElement TshirtItem = driver.findElement(By.xpath("//*[@title='T-shirts']"));
	  if(TshirtItem.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @Test(priority=8)
  public void TestContasUs() {
	  WebElement contas = driver.findElement(By.xpath("//*[@title='Contact Us']"));
	  if(contas.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @Test(priority=9)
  public void TestSignIn() {
	  WebElement signIn = driver.findElement(By.xpath("//*[@title='Log in to your customer account']"));
	  if(signIn.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
  }
  
  @AfterClass
  
  public void teardown() {
	  driver.quit();;
  }
}
