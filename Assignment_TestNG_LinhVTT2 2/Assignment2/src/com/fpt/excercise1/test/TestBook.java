package com.fpt.excercise1.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fpt.excercise1.model.Author;
import com.fpt.excercise1.model.Book;

public class TestBook {
  @Test
  public void TestContructor1() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000);
	  
	  Assert.assertNotNull(book, "creat book from contructor 1 fail!");
  }
  
  @Test
  public void TestContructor2() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  
	  Assert.assertNotNull(book, "creat book from contructor 2 fail!");
  }
  
  @Test
  public void TestGetNameBook() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  
	  Assert.assertEquals(book.getName(), "Tren duong bang", "Method getName() fail!");
  }
  
  @Test
  public void TestGetAuthor() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  
	  Assert.assertEquals(book.getAuthor(), author,"Method getAuthor fail!");
  }
  
  @Test
  public void TestGetPrice() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  
	  Assert.assertEquals(book.getPrice(), 100.000, " Method getPrice fail!");
  }
  
  @Test
  public void TestSetPrice() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  book.setPrice(120.000);
	  
	  Assert.assertEquals(book.getPrice(), 120.000, " Method getPrice fail!");
  }
  
  @Test
  public void TestGetQty() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  
	  Assert.assertEquals(book.getQty(), 5, "Method getQty() fail!");
  }
  
  @Test
  public void TestSetQty() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  
	  book.setQty(10);
	  Assert.assertEquals(book.getQty(), 10, "Method getQty() fail!");
  }
  
  @Test
  public void TestToStirng() {
	  Author author = new Author("Tran Dang Khoa", "khoaDT@gmail.com", 'm');
	  Book book = new Book("Tren duong bang", author, 100.000,5);
	  
	  Assert.assertEquals(book.toString(), "Book[name=Tren duong bang,Author=[name=Tran Dang Khoa,email=khoaDT@gmail.com,gender=m],price=100.0,qty=5]", "Method toString() fail!");
  }
}
