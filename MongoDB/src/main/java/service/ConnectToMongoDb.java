package service;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class ConnectToMongoDb {

	private static final Logger LOGGER = Logger.getLogger(ConnectToMongoDb.class);	

	@SuppressWarnings("resource")
	public MongoDatabase getMongoDbByName(String name) {

		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase(name);		
		LOGGER.info("Connect to database successfully");
		
		return db;
	}

	public MongoCollection<Document> getCollectionByName(String name, MongoDatabase db) {
		if (db == null) {
			throw new IllegalArgumentException("MongoDatabase is NULL");
		}
		return db.getCollection(name);
	}
	

}
