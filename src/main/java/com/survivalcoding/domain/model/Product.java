package com.survivalcoding.domain.model;

import java.util.Objects;

public class Product {
	// 객체 만들때 아래 순서로 작성 (현실세계랑 맞추기 위함)
	// 1. private 멤버 변수
	// 2. 필요하면 생성자 추가
	// 3. getter / setter	읽기 전용, 쓰기 전용을 설정할 수 있다. 수정불가능하게 하고 싶으면 해당 변수의 getter,setter를 지운다.
	// 4. toString()	디버깅 용도로 사용함. 값이 어떻게 저장되었는지 확인 가능
	// 5. 필요하면 equals/ hasCode 재정의(오버라이드)
	public static void main(String[] args) {
		Product product = new Product("33","33",11);
		System.out.println(product.hashCode());
		
		Product product2 = new Product("33","33",11);
		System.out.println(product2.hashCode());
		
		Object object = new Product("33","33",11);
		
		
		System.out.println(product == product2);
		System.out.println(product.equals(product2));
		
	}

	private String id;
	private String name;
	private int unitPrice;
	private String description;
	private String manufaturer;
	private String category;
	private long unitsInStock;
	private String condition;
	
	

	public Product(String id, String name, int unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getManufaturer() {
		return manufaturer;
	}


	public void setManufaturer(String manufaturer) {
		this.manufaturer = manufaturer;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public long getUnitsInStock() {
		return unitsInStock;
	}


	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", description=" + description
				+ ", manufaturer=" + manufaturer + ", category=" + category + ", unitsInStock=" + unitsInStock
				+ ", condition=" + condition + "]";
	}

	
}
