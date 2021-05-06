package com.productorder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productorder.domain.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
