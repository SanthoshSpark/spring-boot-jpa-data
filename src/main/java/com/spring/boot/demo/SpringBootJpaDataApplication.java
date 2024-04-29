package com.spring.boot.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import com.spring.boot.demo.audit.AuditorAwareImpl;
import com.spring.boot.demo.controller.UserController;
import com.spring.boot.demo.exception.ResourceNotFoundException;
import com.spring.boot.demo.model.User;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringBootJpaDataApplication implements CommandLineRunner {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDataApplication.class, args);
	}

	@Autowired
	private UserController userController;
	
	@Override
	public void run(String... args) throws Exception {
		

		//1. Creating the users
		
		
		/*		List<User> usersToStore = Arrays.asList(
						new User("Chaithu","Pasupuleti"),
						new User("Prahash","Pasupuleti"),
						new User("Chandru","Pasupuleti"),
						new User("Srinu", "Chatakonda"),
						new User("Santhosh", "Durairaj"),
						new User("Gunasai", "Tandlam")
				);
				
				
				for(User user:usersToStore) {
					userController.createUser(user);
				}  */
		
		//2. getting the users
				
		/*		
				List<User> usersToView = userController.getAllUsers();
				

				for(User user:usersToView) {
					System.out.println(user);
				} */
				
		//3. get user by id
			
		/*    	try {
					User u1 = userController.getUserById(3L);
					System.out.println(u1);
					
					User u2 = userController.getUserById(6L);
				   	System.out.println(u2);
				}
				catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}		*/

		//4. update the user
			/*	try {
					User u1 = userController.updateUser(3L, new User("Raju", "Raghav"));
					System.out.println(u1);
				}
				catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}  */
		//5. delete user
		System.out.println("\n\nAfter Deleting the user");
		try {
			userController.deleteUser(3L);
			
		List<User> usersToView = userController.getAllUsers();
			

			for(User user:usersToView) {
				System.out.println(user);
			}
			
		}
		catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
