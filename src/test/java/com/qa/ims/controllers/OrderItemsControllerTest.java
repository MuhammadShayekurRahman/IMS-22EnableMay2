package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.OrderItemsController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemsDao;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemsControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrderItemsDAO dao;
	
	@InjectMocks
	private OrderItemsController controller;
	
	@Test
	public void testCreate() {
		final long F_CUSTOMER_ID = 1L;
		final long QUANTITY = 1L;
		final long F_ORDER_ID = 1L;
		final long F_ITEM_ID = 1L;
		
		final CustomerDAO customerDAO = new CustomerDAO();
		final OrderDAO orderDAO = new OrderDAO();
		final ItemsDao itemsDao = new ItemsDao();
		final OrderItemsDAO orderItemsDAO = new OrderItemsDAO();
		
		final Items items = itemsDao.read(F_ITEM_ID);
		final Customer customer = customerDAO.read(F_CUSTOMER_ID);
		
		final Order order = new Order(F_ORDER_ID, customer);
		
		final OrderItems created = new OrderItems(QUANTITY, order, items);
		
		////////////////////////////////////
		
		
		
		Mockito.when(utils.getLong()).thenReturn(QUANTITY, F_ORDER_ID, F_ITEM_ID);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
		
	}
	
	@Test
	public void testReadAll() {
		List<OrderItems> orderItems = new ArrayList<>();
		orderItems.add(new OrderItems(1L, 1L, new Order(1L, new Customer(1L, "jordan", "harrison"), 1L), new Items(1L, "Game", 10f)));

		Mockito.when(dao.readAll()).thenReturn(orderItems);

		assertEquals(orderItems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}
