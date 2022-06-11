package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemsDao;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemsDao itemsDao;
	private Utils utils;
	
	public ItemsController(ItemsDao itemsDao, Utils utils) {
		super();
		this.itemsDao = itemsDao;
		this.utils = utils;
	}
	
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDao.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter an Item name: ");
		String itemName = utils.getString();
		LOGGER.info("Please enter an Item Cost:");
		double itemCost = utils.getDouble();
		Items items = itemsDao.create(new Items(itemName, itemCost));
		LOGGER.info("Item created");
		return items;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter an Item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter an Item Cost");
		double itemCost = utils.getDouble();
		Items items = itemsDao.update(new Items(itemId, itemName, itemCost));
		LOGGER.info("Customer Updated");
		return items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long itemId = utils.getLong();
		return itemsDao.delete(itemId);
	}
	
	
	
}

