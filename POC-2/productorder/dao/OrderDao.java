package com.productorder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productorder.domain.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
