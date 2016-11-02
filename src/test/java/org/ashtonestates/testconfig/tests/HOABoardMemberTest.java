/*
 *
 */
package org.ashtonestates.testconfig.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.ashtonestates.model.HomeOwnerBoardMember;
import org.ashtonestates.model.MasterBoardMember;
import org.ashtonestates.model.TownhomeBoardMember;
import org.ashtonestates.repository.HomeOwnerBoardRepository;
import org.ashtonestates.repository.MasterBoardRepository;
import org.ashtonestates.repository.TownhomeBoardRepository;
import org.ashtonestates.testconfig.TestJpaConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestJpaConfig.class })
public class HOABoardMemberTest {

	@Autowired
	private HomeOwnerBoardRepository hobRepo;

	@Autowired
	private TownhomeBoardRepository tobRepo;

	@Autowired
	private MasterBoardRepository masterRepo;

	@Before
	public void loadDB() {
		final HomeOwnerBoardMember hob1 = new HomeOwnerBoardMember("Bill", "Hunt", "bill.hunt@gmail.com");
		final HomeOwnerBoardMember hob2 = new HomeOwnerBoardMember("John", "Hunt", "john.hunt@gmail.com");
		final HomeOwnerBoardMember hob3 = new HomeOwnerBoardMember("Marsha", "Brady", "marsha.brady@gmail.com");
		final HomeOwnerBoardMember hob4 = new HomeOwnerBoardMember("Chad", "Grant", "chad.grant@gmail.com");
		final HomeOwnerBoardMember hob5 = new HomeOwnerBoardMember("Tammi", "Hunt", "tammi.hunt@gmail.com");

		hobRepo.save(Arrays.asList(hob1, hob2, hob3, hob4, hob5));

		final TownhomeBoardMember tob1 = new TownhomeBoardMember("Bill", "Hunt", "bill.hunt@gmail.com");
		final TownhomeBoardMember tob2 = new TownhomeBoardMember("John", "Hunt", "john.hunt@gmail.com");
		final TownhomeBoardMember tob3 = new TownhomeBoardMember("Marsha", "Brady", "marsha.brady@gmail.com");
		final TownhomeBoardMember tob4 = new TownhomeBoardMember("Chad", "Grant", "chad.grant@gmail.com");
		final TownhomeBoardMember tob5 = new TownhomeBoardMember("Tammi", "Hunt", "tammi.hunt@gmail.com");

		tobRepo.save(Arrays.asList(tob1, tob2, tob3, tob4, tob5));

		final MasterBoardMember mb1 = new MasterBoardMember("Bill", "Hunt", "bill.hunt@gmail.com");
		final MasterBoardMember mb2 = new MasterBoardMember("John", "Hunt", "john.hunt@gmail.com");
		final MasterBoardMember mb3 = new MasterBoardMember("Marsha", "Brady", "marsha.brady@gmail.com");
		final MasterBoardMember mb4 = new MasterBoardMember("Chad", "Grant", "chad.grant@gmail.com");
		final MasterBoardMember mb5 = new MasterBoardMember("Tammi", "Hunt", "tammi.hunt@gmail.com");

		masterRepo.save(Arrays.asList(mb1, mb2, mb3, mb4, mb5));

	}

	@After
	public void cleanDB() {
		hobRepo.deleteAll();
		tobRepo.deleteAll();
		masterRepo.deleteAll();

	}

	@Test
	public void countAllHOB() {
		final long userCount = hobRepo.count();
		assertEquals(5, userCount);
	}

	@Test
	public void findByEmail_HOBnofound() {
		final HomeOwnerBoardMember user = hobRepo.findByEmail("notfound");
		assertNull(user);
	}

	@Test
	public void findByEmail_found() {
		final HomeOwnerBoardMember user = hobRepo.findByEmail("bill.hunt@gmail.com");
		assertNotNull(user);
		assertEquals("Bill", user.getFirstName());
		assertEquals("Hunt", user.getLastName());
	}

}