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
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		
		final long F_CUSTOMER_ID = 1L;
		
		final CustomerDAO customerDAO = new CustomerDAO();
		final Customer customer = customerDAO.read(F_CUSTOMER_ID);
		
		final Order created = new Order(customer);
		
		Mockito.when(utils.getLong()).thenReturn(F_CUSTOMER_ID);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
		
	}
	
	@Test
	public void testReadAll() {
		List<Order> order = new ArrayList<>();
		order.add(new Order(1L, new Customer(1L, "firstName", "surName"), 1L));

		Mockito.when(dao.readAll()).thenReturn(order);

		assertEquals(order, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		
		final long F_CUSTOMER_ID = 1L;
		
		final CustomerDAO customerDAO = new CustomerDAO();
		final Customer customer = customerDAO.read(F_CUSTOMER_ID);
		
		Order updated = new Order(1L, customer);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getLong()).thenReturn(updated.getCustomer().getId());
		
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
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
