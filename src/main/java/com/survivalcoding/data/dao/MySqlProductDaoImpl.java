package com.survivalcoding.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.survivalcoding.domain.model.Product;

public class MySqlProductDaoImpl implements ProductDao {
//	private final static String COLUMN_ID = "p_id";
//	private final static String NAME = "p_name";

	public MySqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
	}

	@Override
	public List<Product> getAll() {
		List<Product> results = new ArrayList<>();

		String sql = "SELECT * FROM product";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33060/kopoctc", "root", "1234");
				Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					String id = rs.getString(COLUMN_ID);
					String name = rs.getString(NAME);
					int unitPrice = rs.getInt("p_unitPrice");
					String description = rs.getString("p_description");
					String category = rs.getString("p_category");
					String manufacturer = rs.getString("p_manufacturer");
					long unitsInStock = rs.getLong("p_unitsInStock");
					String codition = rs.getString("p_codition");

					Product product = new Product(id, name, unitPrice);
					product.setDescription(description);
					product.setCategory(category);
					product.setManufacturer(manufacturer);
					product.setUnitsInStock(unitsInStock);
					product.setCodition(codition);

					results.add(product);
				}
			}
		} catch (SQLException e) {
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		return results;
	}

	@Override
	public void insert(Product product) {
		// PreparedStatement 동적 쿼리 생성: Insert, update, delete 여러번 할 때 고속
		String sql = "insert into product values(?,?,?,?,?,?,?,?);";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.106:33060/kopoctc", "root", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getUnitPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getCategory());
			pstmt.setString(6, product.getManufacturer());
			pstmt.setLong(7, product.getUnitsInStock());
			pstmt.setString(8, product.getCodition());
			pstmt.execute();
		} catch (SQLException e) {
			throw new IllegalStateException("insert 실패 " + e.getMessage());
		}
	}

	@Override
	public void update(Product product) {
		// PreparedStatement 동적 쿼리 생성: Insert, update, delete 여러번 할 때 고속
		String sql = "update into ? set p_name=?,p_unitPrice=?,p_description=?,p_category=?,p_manufacturer=?,p_unitsInStock=?,p_codition=?;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.106:33060/kopoctc", "root", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, TABLE_NAME);
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getUnitPrice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getCategory());
			pstmt.setString(6, product.getManufacturer());
			pstmt.setLong(7, product.getUnitsInStock());
			pstmt.setString(8, product.getCodition());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("update 실패 " + e.getMessage());
		}
	}

	@Override
	public void delete(Product product) {
		String sql = "delete From ? where p_id = ?;";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.106:33060/kopoctc", "root", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, TABLE_NAME);
			pstmt.setString(2, product.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("delete 실패 " + e.getMessage());
		}

	}

}