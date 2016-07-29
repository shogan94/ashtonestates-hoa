/*
 *
 */
package org.ashtonestates;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.ashtonestates.user.model.AshtonStatus;
import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.model.User;
import org.ashtonestates.user.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestJpaConfig.class })
public class UserRepoTest {

	@Autowired
	private UserRepository repository;

	@Before
	public void loadDB() {
		final User user1 = new User("Bill", "Hunt", "password1", "1416 Bradford Ln", "william.l.hunt@gmail.com", Role.ROLE_ADMIN, AshtonStatus.APPROVED);
		final User user2 = new User("Bill", "Walker", "password2", "1 Main Street", "bwalker@gmail.com", Role.ROLE_USER, AshtonStatus.PENDING);
		final User user3 = new User("Stacy", "Layton", "password3", "1408 Bradford Ln", "s_layton@facebook.com", Role.ROLE_USER, AshtonStatus.APPROVED);
		final User user4 = new User("Maria", "Smith", "password4", "1410 Bradford Ln", "msmith12@gmail.com", Role.ROLE_USER, AshtonStatus.PENDING);
		final User user5 = new User("Tammi", "Hunt", "password5", "1416 Bradford Ln", "tammi.hunt@gmail.com", Role.ROLE_USER, AshtonStatus.APPROVED);

		repository.save(user1);
		repository.save(user2);
		repository.save(user3);
		repository.save(user4);
		repository.save(user5);
	}

	@After
	public void cleanDB() {
		repository.deleteAll();
	}

	@Test
	public void countAll() {
		final long count = repository.count();
		assertEquals(5, count);
	}

	@Test
	public void findByEmail_nofound() {
		final User user = repository.findByEmail("notfound");
		assertNull(user);
	}

	@Test
	public void findByEmail_found() {
		final long count = repository.count();
		assertEquals(5, count);

		final User user = repository.findByEmail("william.l.hunt@gmail.com");
		assertNotNull(user);
		assertEquals("Bill", user.getFirstName());
		assertEquals("Hunt", user.getLastName());
	}

	@Test
	public void findAllPending() {
		final List<User> users = repository.findByStatus(AshtonStatus.PENDING);
		assertEquals(2, users.size());
	}

	@Test
	public void findAllApproved() {
		final List<User> users = repository.findByStatus(AshtonStatus.APPROVED);
		assertEquals(3, users.size());
	}

	@Test
	public void findAllUsers() {
		final List<User> users = repository.findByRole(Role.ROLE_USER);
		assertEquals(4, users.size());
	}

	@Test
	public void findAllAdmins() {
		final List<User> users = repository.findByRole(Role.ROLE_ADMIN);
		assertEquals(1, users.size());
	}

	@Test
	public void updatePendingToApproved() {
		List<User> users = repository.findByStatus(AshtonStatus.APPROVED);
		assertEquals(3, users.size());

		User user = repository.findByEmail("bwalker@gmail.com");
		assertNotNull(user);
		assertEquals("Bill", user.getFirstName());
		assertEquals("Walker", user.getLastName());
		assertEquals(AshtonStatus.PENDING, user.getStatus());

		user.setStatus(AshtonStatus.APPROVED);
		repository.save(user);

		users = repository.findByStatus(AshtonStatus.APPROVED);
		assertEquals(4, users.size());

		user = repository.findByEmail("bwalker@gmail.com");
		assertNotNull(user);
		assertEquals("Bill", user.getFirstName());
		assertEquals("Walker", user.getLastName());
		assertEquals(AshtonStatus.APPROVED, user.getStatus());
	}

}
