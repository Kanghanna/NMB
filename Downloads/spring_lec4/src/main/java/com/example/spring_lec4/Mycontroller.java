package com.example.spring_lec4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class Mycontroller {
	
	@RequestMapping("/template2")
	public String template2(Model m) {
	    m.addAttribute("value1", 100);
	    m.addAttribute("value2", "Hello, Paragraph!");
	    
	    Book book = new Book("김철수", "부자되는 방법", 10000);
	    m.addAttribute("mybook", book);
	    
	    
	    
	    return "template2";
	}
	
	class Author implements Serializable {
		private String name;

		public Author() { super(); }

		public Author(String name) {
		    super();
		    this.name = name;
		}

		public String getName() {
		    return name;
		}
		public void setName(String name) {
		    this.name = name;
		}
	}

		class Book implements Serializable {
		private String name;
		private Author author;
		private int price;
		private boolean sale;
		private double saleAmount;

		public Book() { super(); }
		public Book(String authorName, String bookName, int price) {
		    super();
		    this.author = new Author(authorName);
		    this.name = bookName;
		    this.price = price;
		}
		public Book(String authorName, String bookName, int price, boolean sale, double saleAmount) {
		    super();
		    this.author = new Author(authorName);
		    this.name = bookName;
		    this.price = price;
		    this.sale = sale;
		    this.saleAmount = saleAmount;
		}

		public String getName() {
		    return name;
		}
		public void setName(String name) {
		    this.name = name;
		}
		public Author getAuthor() {
		    return author;
		}
		public void setAuthor(Author author) {
		    this.author = author;
		}
		public int getPrice() {
		    return price;
		}
		public void setPrice(int price) {
		    this.price = price;
		}
		public boolean isSale() {
		    return sale;
		}
		public void setSale(boolean sale) {
		    this.sale = sale;
		}
		public double getSaleAmount() {
		    return saleAmount;
		}
		public void setSaleAmount(double saleAmount) {
		    this.saleAmount = saleAmount;
		}
	}
		
		@RequestMapping("/template3")
		public String template3(Model m) {
		    m.addAttribute("condition1", true);
		    m.addAttribute("condition2", false);
		    
		    Book book = new Book("김철수", "부자되는 방법", 10000);
		    book.setSale(true);
		    book.setSaleAmount(0.3);
		    m.addAttribute("book", book);
		    
		    List<Book> bookList = new ArrayList<>();
		    bookList.add(new Book("김철수", "부자되는 방법 1", 10000));
		    bookList.add(new Book("김철수", "부자되는 방법 2", 20000, true, 0.2));
		    bookList.add(new Book("김철수", "부자되는 방법 3", 30000));
		    bookList.add(new Book("김철수", "부자되는 방법 4", 40000, true, 0.3));
		    m.addAttribute("book_list", bookList);
		    
		    Map<String, Book> bookMap = new HashMap<>();
		    bookMap.put("book1", new Book("김철수", "부자되는 방법 1", 10000));
		    bookMap.put("book2", new Book("김철수", "부자되는 방법 2", 20000, true, 0.2));
		    bookMap.put("book3", new Book("김철수", "부자되는 방법 3", 30000));
		    bookMap.put("book4", new Book("김철수", "부자되는 방법 4", 40000, true, 0.3));
		    m.addAttribute("book_map", bookMap);
		    
		    m.addAttribute("grade", "A");
		    
		    return "template3";
		}
		
		@RequestMapping("/template4")
		public String template4(Model m, HttpServletRequest request) {
		    m.addAttribute("value", "Hello");
		    request.getSession().setAttribute("session_value1", "Hello From Session");
		    request.getSession().setAttribute("session_value2", 1234);
		    
		    return "template4";
		}
		
		@RequestMapping("/template5")
		public String template5(Model m) {
			m.addAttribute("today", new Date());
			m.addAttribute("inum", 123456789);
			m.addAttribute("dnum", 12345.12345);
			m.addAttribute("str", " \tHello\t\n ");
			m.addAttribute("long_str", "Long string Long string Long string Long string Long string");
			ArrayList<String> strList = new ArrayList<>();
			strList.add("str1");
			strList.add("str2");
			strList.add("str3");
			m.addAttribute("str_list", strList);
			
			return "template5";
		}
		
		
}
