package com.productorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productorder.dao.OrderDao;
import com.productorder.dao.ProductDao;
import com.productorder.domain.Order;
import com.productorder.domain.Product;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductDao prdctdao;
	
	@Autowired
	private OrderDao ordrdao;

	

	public Product addProduct(Product product) {
		return prdctdao.save(product);
	}


	public Iterable<Product> getAllProducts() {
		return prdctdao.findAll();
	}


	public Optional<Product> getProductById(Integer product_Id) {
		return prdctdao.findById(product_Id);
	}


	public Iterable<Order> getAllOrders() {
		return ordrdao.findAll();
	}


	public Optional<Order> getOrderById(Integer order_Id) {
		return ordrdao.findById(order_Id);
	}


	public int placeOrder(int product_id,int quantity, Order order) {
		int result = 1;
		
		Product product = prdctdao.findById(product_id).orElse(new Product());
		
		if(product == null) {
			return result;
		}
		order.setQuantity(quantity);
		order.setProduct(product);
		ordrdao.save(order);
		
		result = 0;
		return result;
	}
	
	public int updateOrder(Integer order_id, Integer quantity ) {
		int result = 1;
		
		Order order = ordrdao.findById(order_id).orElse(new Order());
		if(order.getId() == 0) {
			return result;
		}
		
		order.setQuantity(quantity);
		ordrdao.save(order);
		
		result=0;
		
		return result;
	}


	
	
	
}
