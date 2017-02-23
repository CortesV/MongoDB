package com.devcortes.run;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devcortes.components.entity.User;
import com.devcortes.components.service.UserDao;

import service.UserService;

@SpringBootApplication
public class MongoDbApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
		
		UserDao userDao = new UserDao();
		UserService userService = new UserService();
		
		
		
		User user = new User();
		user.setId(1);
		user.setLogin("Cortes");
		user.setPassword("1");		
		
		User user1 = new User();
		user1.setId(2);
		user1.setLogin("Vlad");
		user1.setPassword("1234");
		
		User user2 = new User();
		user2.setId(3);
		user2.setLogin("Oleg");
		user2.setPassword("12345");
		
		User user3 = new User();
		user3.setId(4);
		user3.setLogin("CortesV");
		user3.setPassword("123456");
		
		List<User> listUser = new ArrayList<>();
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);		
		
		userService.clearCollection(userDao);
		
		userService.add(user, userDao);
		
		userService.addMany(listUser, userDao);
		
		
		userService.readAll(userDao);
		System.out.println("--------------------------------------------------");
		
		userService.updateLogin(user2, userDao);
		
		userService.readAll(userDao);
		System.out.println("--------------------------------------------------");
		
		userService.deleteByLogin("Cortes", userDao);
		
		userService.readAll(userDao);
		System.out.println("--------------------------------------------------");
		
		userService.getByLogin("CortesV", userDao);
		System.out.println("--------------------------------------------------");
		
	}
}
