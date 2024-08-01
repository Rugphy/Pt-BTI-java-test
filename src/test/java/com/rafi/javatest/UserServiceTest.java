package com.rafi.javatest;

import com.rafi.javatest.Entity.User;
import com.rafi.javatest.Repository.UserRepository;
import com.rafi.javatest.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
	public class UserServiceTest {
		@Mock
		private UserRepository userRepository;

		@InjectMocks
		private UserService userService;

		@Test
		public void testAddUser() {
			User user = new User();
			user.setUsername("testUser");
			user.setRole("admin");

			when(userRepository.save(user)).thenReturn(user);

			User result = userService.addUser(user);
			assertEquals("testUser", result.getUsername());
			assertEquals("admin", result.getRole());
		}

	@Test
	public void testGetUserById() {
		User user = new User();
		user.setIdUser(1L);
		user.setUsername("testUser");
		user.setRole("admin");

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		User result = userService.getUserById(1L);
		assertEquals("testUser", result.getUsername());
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = List.of(new User(), new User());

		when(userRepository.findAll()).thenReturn(users);

		List<User> result = userService.getAllUsers();
		assertEquals(2, result.size());
	}
	}

