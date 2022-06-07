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
import com.qa.ims.utils.DBUtils;

import com.qa.ims.persistence.domain.Items;

public class ItemsDao implements Dao<Items>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	public Items itemsModelFromResultSet(ResultSet resultSet) throws SQLException{
		Long itemId = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		double itemCost = resultSet.getDouble("item_cost");
		return new Items(itemId, itemName, itemCost);
		
	}
	
	@Override
	public List<Items> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Items read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Items create(Items t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Items update(Items t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
