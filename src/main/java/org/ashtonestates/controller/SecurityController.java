package org.ashtonestates.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.ashtonestates.user.model.DocumentType;
import org.ashtonestates.user.model.Documents;
import org.ashtonestates.user.model.Role;
import org.ashtonestates.user.model.RoleType;
import org.ashtonestates.user.model.State;
import org.ashtonestates.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController extends BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/security/initData", method = RequestMethod.GET)
	public String initData() {

		userRepo.deleteAll();
		roleRepo.deleteAll();

		final Role userRole = roleRepo.save(new Role(RoleType.USER));
		final Role adminRole = roleRepo.save(new Role(RoleType.ADMIN));

		final User user1 = new User();
		user1.setFirstName("william");
		user1.setLastName("hunt");
		user1.setAddress("1416 bradford ln");
		user1.setEmail("william.l.hunt@gmail.com");
		user1.setPassword("password1");
		user1.setRole(adminRole);
		user1.setState(State.APPROVED);

		final User user2 = new User();
		user2.setFirstName("tammi");
		user2.setLastName("hunt");
		user2.setAddress("1416 bradford ln");
		user2.setEmail("tammi.hunt@gmail.com");
		user2.setPassword("password1");
		user2.setRole(userRole);
		user2.setState(State.PENDING);

		userRepo.save(Arrays.asList(user1, user2));

		return "redirect:/";
	}

	@RequestMapping(value = "/security/initDocs", method = RequestMethod.GET)
	public String initDocs(final HttpSession session) throws IOException {
		docRepo.deleteAll();

		LOGGER.info("***** home public docs");
		File directory = new File("c:/Temp/ashton-documents/home-public-docs");
		Collection<File> files = FileUtils.listFiles(directory, FileFilterUtils.makeFileOnly(null), null);
		files.forEach(f -> addFile(f, DocumentType.PUBLIC_HOMES));

		LOGGER.info("***** home resident docs");
		directory = new File("c:/Temp/ashton-documents/home-resident-docs");
		files = FileUtils.listFiles(directory, FileFilterUtils.makeFileOnly(null), null);
		files.forEach(f -> addFile(f, DocumentType.RESIDENT_HOMES));

		LOGGER.info("***** townhome public docs");
		directory = new File("c:/Temp/ashton-documents/townhome-public-docs");
		files = FileUtils.listFiles(directory, FileFilterUtils.makeFileOnly(null), null);
		files.forEach(f -> addFile(f, DocumentType.PUBLIC_TOWNHOME));

		LOGGER.info("***** townhome resident docs");
		directory = new File("c:/Temp/ashton-documents/townhome-resident-docs");
		files = FileUtils.listFiles(directory, FileFilterUtils.makeFileOnly(null), null);
		files.forEach(f -> addFile(f, DocumentType.RESIDENT_TOWNHOME));

		return "redirect:/";
	}

	private void addFile(final File f, final DocumentType docType) {
		final Documents doc = new Documents();
		doc.setName(f.getName());
		doc.setPath(f.getPath());
		doc.setSize(f.length());
		doc.setUploadedDate(new Date().toString());
		doc.setDocumentType(docType);
		docRepo.save(doc);
	}

}
