package com.survivalcoding.data.dao;

import java.util.List;
import com.survivalcoding.domain.model.Product;

// Data Access Object
// DB랑 연결할 놈
public interface ProductDao {
    // interface 안에서는 public 생략되어 있고 public 만 됨
	
	// interface 안에 작성한 멤버 = public final static 이 생략되어 있다.
	
	String TABLE_NAME = "product"; 
	String COLUMN_ID = "p_id"; 
	String NAME = "p_name";
	
    List<Product> getAll();

    void insert(Product product);

    void update(Product product);

    void delete(Product product);
}
