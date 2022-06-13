package com.survivalcoding.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.survivalcoding.domain.model.Product;

// 다형성

public class ProductRepository {

	private List<Product> products = new ArrayList<>();
	
	public ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334 X 750 Retina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufaturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		phone.setDescription("4.7-inch, 1334 X 750 Retina HD display");
		phone.setCategory("!Smart Phone");
		phone.setManufaturer("!Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("Refubished");
		
		Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
		phone.setDescription("4.7-inch, 1334 X 750 Retina HD display");
		phone.setCategory("?Smart Phone");
		phone.setManufaturer("?Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("Old");
		
		products.add(phone);
		products.add(notebook);
		products.add(tablet);
		
	}
	
	public List<Product> getAllProducts() {
		return products;
	}
}
