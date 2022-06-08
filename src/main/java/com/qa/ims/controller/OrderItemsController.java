package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemsDao;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
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
		OrderItemsDAO orderItemsDAO = new OrderItemsDAO();

		LOGGER.info("Please enter Customer ID:");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter Order ID:");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter Item ID:");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter Quantity:");
		Long quantity = utils.getLong();
		
		CustomerDAO customerDAO = new CustomerDAO();
		OrderDAO orderDAO = new OrderDAO();
		ItemsDao itemsDao = new ItemsDao();
		
		Items items = itemsDao.read(itemId);
		Customer customer = customerDAO.read(customerId);
		
		Order order = new Order(orderId, customer);
		
		OrderItems orderItems = orderItemsDAO.create(new OrderItems(quantity, order, items));
		
		
		
		//OrderItems orderItems = orderItemsDAO.create(newOrderItems);
		
		LOGGER.info("Item Added to order");
		return orderItems;
	}

	@Override
	public OrderItems update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order item you would like to delete");
		Long orderItemsId = utils.getLong();
		return orderItemsDAO.delete(orderItemsId);
	}

}
