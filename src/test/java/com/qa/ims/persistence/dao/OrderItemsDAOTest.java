package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAOTest {
	
	private final OrderItemsDAO DAO = new OrderItemsDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
	
		
	final OrderItems created = new OrderItems(2L, 1L, new Order(1L, new Customer(1L, "jordan", "harrison")), new Items(1L, "Game", 10f));
	assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<OrderItems> expected = new ArrayList<>();
		expected.add(new OrderItems(1L, 1L, new Order(1L, new Customer(1L, "jordan", "harrison")), new Items(1L, "Game", 10f)));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new OrderItems(1L, 1L, new Order(1L, new Customer(1L, "jordan", "harrison")), new Items(1L, "Game", 10f)), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new OrderItems(1L, 1L, new Order(1L, new Customer(1L, "jordan", "harrison")), new Items(1L, "Game", 10f)), DAO.read(ID));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
