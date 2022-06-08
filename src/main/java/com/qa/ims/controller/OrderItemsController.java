package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;


public class OrderItemsController implements CrudController<OrderItems> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderItemsDAO orderItemsDAO;
	private Utils utils;
	
	
	public OrderItemsController(OrderItemsDAO orderItemsDAO, Utils utils) {
		super();
		this.orderItemsDAO = orderItemsDAO;
		this.utils = utils;
	}

	@Override
	public List<OrderItems> readAll() {
		List<OrderItems> orderItem = orderItemsDAO.readAll();
		for (OrderItems orderItems : orderItem) {
			LOGGER.info(orderItems);
		}
		return orderItem;
	}

	@Override
	public OrderItems create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItems update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
