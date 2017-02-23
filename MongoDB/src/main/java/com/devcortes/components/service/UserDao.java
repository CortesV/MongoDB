package com.devcortes.components.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devcortes.components.entity.User;
import com.devcortes.components.interfaces.IUserDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import service.ConnectToMongoDb;

@Repository
public class UserDao implements IUserDao {

	private static final Logger LOGGER = Logger.getLogger(UserDao.class);
	private static final String DATABASE = "projectdb";


	@Override
	public void add(User user) {

		try {

			ConnectToMongoDb connectToMongoDb = new ConnectToMongoDb();
			MongoDatabase db = connectToMongoDb.getMongoDbByName(DATABASE);
			MongoCollection<Document> collection = db.getCollection(User.TABLE_NAME);
			Document c1 = new Document();
			c1.append("id", user.getId());
			c1.append("login", user.getLogin());
			c1.append("password", user.getPassword());

			collection.insertOne(c1);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
	}

	@Override
	public void addMany(List<User> users) {

		try {

			ConnectToMongoDb connectToMongoDb = new ConnectToMongoDb();
			MongoDatabase db = connectToMongoDb.getMongoDbByName(DATABASE);
			MongoCollection<Document> collection = db.getCollection(User.TABLE_NAME);

			List<Document> documentOfUsers = new ArrayList<>();
			for (User user : users) {

				Document doc = new Document();
				doc.append("id", user.getId());
				doc.append("login", user.getLogin());
				doc.append("password", user.getPassword());
				documentOfUsers.add(doc);
			}

			collection.insertMany(documentOfUsers);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

	@Override
	public void readAll() {		
		
		ConnectToMongoDb connectToMongoDb = new ConnectToMongoDb();
		MongoDatabase db = connectToMongoDb.getMongoDbByName(DATABASE);
		MongoCollection<Document> collection = db.getCollection(User.TABLE_NAME);
		for (Document user : collection.find()) {
			System.out.println(String.format("Read record id %1$s login %2$s password %3$s", user.get("id"), user.get("login"), user.get("password")));
		}
	}

	@Override
	public void deleteByLogin(String login) {
		
		try {

			ConnectToMongoDb connectToMongoDb = new ConnectToMongoDb();
			MongoDatabase db = connectToMongoDb.getMongoDbByName(DATABASE);
			MongoCollection<Document> collection = db.getCollection(User.TABLE_NAME);

			collection.deleteOne(new Document("login", login));

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}
	
	@Override
	public void clearCollection() {
		
		try {

			ConnectToMongoDb connectToMongoDb = new ConnectToMongoDb();
			MongoDatabase db = connectToMongoDb.getMongoDbByName(DATABASE);
			MongoCollection<Document> collection = db.getCollection(User.TABLE_NAME);

			collection.drop();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

	}

}
