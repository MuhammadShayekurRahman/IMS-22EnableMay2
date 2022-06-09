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
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("f_customer_id");
		String firstName= resultSet.getString("first_name");
		String surName = resultSet.getString("surname");
		Long costs = resultSet.getLong("Cost");
		Customer customer = new Customer(customerId, firstName, surName);
		return new Order(orderId, customer, costs);
	}
	
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select sum(oi.quantity*i.item_cost) as Cost, o.order_id, f_customer_id, first_name, surname from `order` o left join customers c on o.f_customer_id=c.id left join order_items oi on oi.f_order_id=o.order_id left join items i on i.item_id=oi.f_item_id group by o.order_id;");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select sum(oi.quantity*i.item_cost) as Cost, o.order_id, f_customer_id, first_name, surname from `order` o left join customers c on o.f_customer_id=c.id left join order_items oi on oi.f_order_id=o.order_id left join items i on i.item_id=oi.f_item_id group by o.order_id ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("select sum(oi.quantity*i.item_cost) as Cost, o.order_id, f_customer_id, first_name, surname from `order` o left join customers c on o.f_customer_id=c.id left join order_items oi on oi.f_order_id=o.order_id left join items i on i.item_id=oi.f_item_id where order_id=? group by o.order_id ");) {
			statement.setLong(1, orderId);
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
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO `order`(f_customer_id) VALUES (?)");) {
			statement.setLong(1, order.getCustomer().getId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE `order` SET f_customer_id = ? WHERE order_id = ?");) {
			
			Long customerId = order.getCustomer().getId();
			Long orderId = order.getOrderId();
			
			
			statement.setLong(1, customerId);
			statement.setLong(2, orderId);
			statement.executeUpdate();
			return read(orderId);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM `order` WHERE order_id = ?");) {
			statement.setLong(1, orderId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
	

}
