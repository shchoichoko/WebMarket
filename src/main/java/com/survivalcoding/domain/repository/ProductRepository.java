package com.survivalcoding.domain.repository;

import java.util.List;

import com.survivalcoding.data.ProductRepositoryImpl;
import com.survivalcoding.domain.model.Product;

public interface ProductRepository {
   // 공통기능을 인터페이스에 저장
   public static ProductRepository getInstance() {
      return ProductRepositoryImpl.getInstance();
   }
   
   public List<Product> getAllProducts();
   
   public Product getProductById(String id);
   
   public void addProduct(Product product);
}