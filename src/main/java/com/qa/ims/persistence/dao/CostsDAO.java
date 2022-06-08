package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Costs;
import com.qa.ims.utils.DBUtils;

public class CostsDAO implements Dao<Costs>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Costs modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("f_order_id");
		Long cost = resultSet.getLong("Cost");
		return new Costs(orderId, cost);
		
	}
	@Override
	public List<Costs> readAll() {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select sum(oi.quantity*i.item_cost) as Cost, oi.f_order_id from order_items oi left join items i on i.item_id=oi.f_item_id group by oi.f_order_id;");) {
				List<Costs> cost = new ArrayList<>();
				while (resultSet.next()) {
					cost.add(modelFromResultSet(resultSet));
				}
				return cost;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return new ArrayList<>();
	}


	@Override
	public Costs read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Costs create(Costs t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Costs update(Costs t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	

}
