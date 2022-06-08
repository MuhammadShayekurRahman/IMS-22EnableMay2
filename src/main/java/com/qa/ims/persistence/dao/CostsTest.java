package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CostsTest {
	
	public CostsTest(Long orderId, Long cost) {
	}
	
	
	public CostsTest modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("f_order_id");
		Long cost = resultSet.getLong("Cost");
		return new CostsTest(orderId, cost);
	}
	public List<CostsTest> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select sum(oi.quantity*i.item_cost) as Cost, oi.f_order_id from order_items oi left join items i on i.item_id=oi.f_item_id group by oi.f_order_id;");) {
			List<CostsTest> cost = new ArrayList<>();
			while (resultSet.next()) {
				cost.add(modelFromResultSet(resultSet));
			}
			return cost;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	
	
}
