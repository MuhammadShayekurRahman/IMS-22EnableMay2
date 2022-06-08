package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAO implements Dao<OrderItems>{
    
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItemsId = resultSet.getLong("order_item_id");
		Long orderId = resultSet.getLong("order_id");
		Long quantity = resultSet.getLong("quantity");
		Long customerId = resultSet.getLong("f_customer_id");
		String firstName= resultSet.getString("first_name");
		String surName = resultSet.getString("surname");
		Long itemId = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		Long itemCost = resultSet.getLong("item_cost");
		Customer customer = new Customer(customerId, firstName, surName);
		Order order = new Order(orderId, customer);
		Items items = new Items(itemId, itemName, itemCost);
		
		return new OrderItems(orderItemsId, quantity, order, items); 
		
	}
	@Override
	public List<OrderItems> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT oi.order_item_id, o.order_id, o.f_customer_id, c.first_name, c.surname, oi.quantity, i.item_id, i.item_name, i.item_cost FROM `order` o left join customers c on o.f_customer_id=c.id left join order_items oi on oi.f_order_id=o.order_id left join items i on i.item_id=oi.f_item_id;");) {
			List<OrderItems> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public OrderItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItems read(Long orderItemsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_items WHERE order_item_id = ?");) {
			statement.setLong(1, orderItemsId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItems create(OrderItems orderItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(quantity, f_order_id, f_item_id) values (?, ?, ?);");) {
			statement.setLong(1, orderItems.getQuantity());
			statement.setLong(2, orderItems.getOrder().getOrderId());
			statement.setLong(3, orderItems.getItems().getItemId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItems update(OrderItems orderItems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long orderItemsId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE order_item_id = ?");) {
			statement.setLong(1, orderItemsId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	

}
