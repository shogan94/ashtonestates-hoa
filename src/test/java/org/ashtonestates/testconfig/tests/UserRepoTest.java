/*
 *
 */
package org.ashtonestates.testconfig.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ashtonestates.model.Role;
import org.ashtonestates.model.State;
import org.ashtonestates.model.User;
import org.ashtonestates.repository.UserRepository;
import org.ashtonestates.testconfig.TestJpaConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestJpaConfig.class })
public class UserRepoTest {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;

	@Before
	public void loadDB() {
		final User user1 = new User("Bill", "Hunt", "password1", "1416 Bradford Ln", "william.l.hunt@gmail.com", State.APPROVED, Role.ADMIN);
		final User user2 = new User("Bill", "Walker", "password2", "1 Main Street", "bwalker@gmail.com", State.PENDING, Role.USER);
		final User user3 = new User("Stacy", "Layton", "password3", "1408 Bradford Ln", "s_layton@facebook.com", State.APPROVED, Role.USER);
		final User user4 = new User("Maria", "Smith", "password4", "1410 Bradford Ln", "msmith12@gmail.com", State.PENDING, Role.USER);
		final User user5 = new User("Tammi", "Hunt", "password5", "1416 Bradford Ln", "tammi.hunt@gmail.com", State.APPROVED, Role.USER);

		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);
		userRepo.save(user4);
		userRepo.save(user5);
	}

	@After
	public void cleanDB() {
		userRepo.deleteAll();
	}

	@Test
	public void countAllUsers() {
		final long userCount = userRepo.count();
		assertEquals(5, userCount);
	}

	@Test
	public void findByEmail_nofound() {
		final User user = userRepo.findByEmail("notfound");
		assertNull(user);
	}

	@Test
	public void findByEmail_found() {
		final long count = userRepo.count();
		assertEquals(5, count);

		final User user = userRepo.findByEmail("william.l.hunt@gmail.com");
		assertNotNull(user);
		assertEquals("Bill", user.getFirstName());
		assertEquals("Hunt", user.getLastName());
	}

	@Test
	public void findAllPending() {
		final List<User> users = userRepo.findByState(State.PENDING);
		assertEquals(2, users.size());
	}

	@Test
	public void findAllApproved() {
		final List<User> users = userRepo.findByState(State.APPROVED);
		assertEquals(3, users.size());
	}

	@Test
	public void findAllUsers() {
		final List<User> users = userRepo.findByRole(Role.USER);
		assertEquals(4, users.size());
	}

	@Test
	public void findAllAdmins() {
		final List<User> users = userRepo.findByRole(Role.ADMIN);
		assertEquals(1, users.size());
	}

	@Test
	public void updatePendingToApproved() {
		List<User> users = userRepo.findByState(State.APPROVED);
		assertEquals(3, users.size());

		User user = userRepo.findByEmail("bwalker@gmail.com");
		assertNotNull(user);
		assertEquals("Bill", user.getFirstName());
		assertEquals("Walker", user.getLastName());
		assertEquals(State.PENDING, user.getState());

		user.setState(State.APPROVED);
		userRepo.save(user);

		users = userRepo.findByState(State.APPROVED);
		assertEquals(4, users.size());

		user = userRepo.findByEmail("bwalker@gmail.com");
		assertNotNull(user);
		assertEquals("Bill", user.getFirstName());
		assertEquals("Walker", user.getLastName());
		assertEquals(State.APPROVED, user.getState());
	}

	@Test
	public void testPassword() {

		assertNotNull(passwordEncoder);

		final User user = userRepo.findByEmail("william.l.hunt@gmail.com");
		System.out.println(user);

		assertTrue(passwordEncoder.matches("password1", user.getPassword()));
	}
}
