/*
 *
 */
package org.ashtonestates.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.ashtonestates.user.model.DocumentType;
import org.ashtonestates.user.model.Documents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.minidev.json.JSONObject;

@RestController
public class UploadController extends BaseController {

	private static final String PUBLIC_HOME_DIRECTORY = "c:/Temp/ashton-documents/home-public-docs";
	private static final String RESIDENT_HOME_DIRECTORY = "c:/Temp/ashton-documents/home-resident-docs";
	private static final String PUBLIC_TOWNHOME_DIRECTORY = "c:/Temp/ashton-documents/townhome-public-docs";
	private static final String RESIDENT_TOWNHOME_DIRECTORY = "c:/Temp/ashton-documents/townhome-resident-docs";

	private static Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

	@PostMapping(value = "/admin/uploadPublicHome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadPublicHome(final HttpServletRequest request, @RequestParam final CommonsMultipartFile file) {

		if (file != null) {
			final File uploadedFile = new File(String.format("%s/%s", PUBLIC_HOME_DIRECTORY, file.getOriginalFilename()));
			final Documents samename = docRepo.findByPath(uploadedFile.getPath());
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				LOGGER.error("Filename already exists, please rename or delete old one and try again.");
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {
				LOGGER.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(uploadedFile.getPath());
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.PUBLIC_HOMES);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					LOGGER.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping(value = "/admin/uploadResidentHome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadResidentHome(final HttpServletRequest request, @RequestParam final CommonsMultipartFile file) {
		if (file != null) {
			final String originalFilename = file.getOriginalFilename();
			final Documents samename = docRepo.findByName(originalFilename);
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {
				final File uploadedFile = new File(String.format("%s/%s", RESIDENT_HOME_DIRECTORY, file.getOriginalFilename()));
				LOGGER.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(uploadedFile.getPath());
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.RESIDENT_HOMES);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					LOGGER.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping(value = "/admin/uploadPublicTownhome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadPublicTownhome(final HttpServletRequest request, @RequestParam final CommonsMultipartFile file) {

		if (file != null) {
			final String originalFilename = file.getOriginalFilename();
			final Documents samename = docRepo.findByName(originalFilename);
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {
				final File uploadedFile = new File(String.format("%s/%s", PUBLIC_TOWNHOME_DIRECTORY, file.getOriginalFilename()));

				LOGGER.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(uploadedFile.getPath());
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.PUBLIC_TOWNHOME);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					LOGGER.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping(value = "/admin/uploadResidentTownhome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadResidentTownhome(final HttpServletRequest request, @RequestParam final CommonsMultipartFile file) {
		if (file != null) {
			final String originalFilename = file.getOriginalFilename();
			final Documents samename = docRepo.findByName(originalFilename);
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {

				final File uploadedFile = new File(String.format("%s/%s", RESIDENT_TOWNHOME_DIRECTORY, file.getOriginalFilename()));

				LOGGER.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(uploadedFile.getPath());
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.RESIDENT_TOWNHOME);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					LOGGER.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}