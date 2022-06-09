package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;


public class OrderController implements CrudController<Order>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		CustomerDAO customerDAO = new CustomerDAO();
		
		LOGGER.info("Please enter a Customer ID");
		Long customerId = utils.getLong();
		
		
		Customer customer = customerDAO.read(customerId);
		Order order = orderDAO.create(new Order(customer));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {

		LOGGER.info("Please enter the id of the order you would like to update");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter a Customer ID");
		Long customerId = utils.getLong();
		
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.read(customerId);
		
		Order order = orderDAO.update(new Order(orderId, customer));
		LOGGER.info("Customer Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderId = utils.getLong();
		return orderDAO.delete(orderId);
	}
	

}
