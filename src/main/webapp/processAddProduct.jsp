<%@page import="com.survivalcoding.domain.repository.ProductRepository"%>
<%@page import="com.survivalcoding.domain.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//post로 넘어온것
request.setCharacterEncoding("UTF-8");//한글 깨짐 방지
String productId = request.getParameter("productId");
String name = request.getParameter("name");
int unitPrice = Integer.parseInt(request.getParameter("unitPrice"));
String description = request.getParameter("description");
String manufacturer = request.getParameter("manufacturer");
String category = request.getParameter("category");
int unitsInStock = Integer.parseInt(request.getParameter("unitsInStock"));
String condition = request.getParameter("condition");


ProductRepository repository = ProductRepository.getInstance();

Product product = new Product(productId, name, unitPrice);
product.setDescription(description);
product.setManufacturer(manufacturer);
product.setCategory(category);
product.setUnitsInStock(unitsInStock);
product.setCondition(condition);

repository.addProduct(product);

response.sendRedirect("products.jsp");
%>