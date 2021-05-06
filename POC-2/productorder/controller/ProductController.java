package com.productorder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productorder.domain.Message;
import com.productorder.domain.Order;
import com.productorder.domain.Product;
import com.productorder.service.ProductService;

@RestController
@RequestMapping("/rest")
public class ProductController {
	
	
	@Autowired
	private ProductService prdctsrvc;
	
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return prdctsrvc.addProduct(product);
	}
	
	@GetMapping("/display/productList")
	public Iterable<Product> getAllProducts() {
		return prdctsrvc.getAllProducts();
	}
	
	@GetMapping("/displayProduct/{product_id}")
	public Optional<Product> getProductById(@PathVariable("product_id") Integer product_Id) {
		return prdctsrvc.getProductById(product_Id);
	}
	
	@GetMapping("/displayAllOrders")
	public Iterable<Order> getAllOrders() {
		return prdctsrvc.getAllOrders();
	}
	
	@GetMapping("/displayOrder/{order_id}")
	public Optional<Order> getOrderById(@PathVariable("order_id") Integer order_Id) {
		return prdctsrvc.getOrderById(order_Id);
	}
	
	@GetMapping("/placeOrder")
	public Message placeOrder(@RequestParam("product_id") Integer product_id,@RequestParam("quantity") Integer quantity) {
		Message msg = new Message();
		Order order = new Order();
		int code=prdctsrvc.placeOrder(product_id,quantity,order);
		if(code == 0) {
			msg.setCode(code);
			msg.setMessage("sucess");
		}
		else {
			msg.setCode(code);
			msg.setMessage("unsucessful");
		}
		return msg;
	}
	
	@GetMapping("/updateOrder")
	public Message updateOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
		Message msg = new Message();
		
		int code = prdctsrvc.updateOrder(id, quantity);
		
		if(code == 0) {
			msg.setCode(code);
			msg.setMessage("sucess");
		}
		else {
			msg.setCode(code);
			msg.setMessage("unsucessful");
		}
		return msg;
	}
}
