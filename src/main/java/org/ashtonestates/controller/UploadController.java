/*
 *
 */
package org.ashtonestates.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import org.ashtonestates.model.DocumentType;
import org.ashtonestates.model.Documents;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;

@RestController
@Slf4j
public class UploadController extends BaseController {

	private static final String PUBLIC_HOME_DIRECTORY = "/home/ashtones/documents/home-public-docs";
	private static final String RESIDENT_HOME_DIRECTORY = "/home/ashtones/documents/home-resident-docs";
	private static final String PUBLIC_TOWNHOME_DIRECTORY = "/home/ashtones/documents/townhome-public-docs";
	private static final String RESIDENT_TOWNHOME_DIRECTORY = "/home/ashtones/documents/townhome-resident-docs";

	@PostMapping(value = "/admin/uploadPublicHome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadPublicHome(@RequestParam final CommonsMultipartFile file) {

		if (file != null) {
			final File uploadedFile = new File(String.format("%s/%s", PUBLIC_HOME_DIRECTORY, file.getOriginalFilename()));
			final Documents samename = docRepo.findByPath(uploadedFile.getPath());
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				log.error("Filename already exists, please rename or delete old one and try again.");
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {
				log.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(StringUtils.delete(uploadedFile.getPath(), "/home/ashtones"));
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.PUBLIC_HOMES);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					log.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping(value = "/admin/uploadResidentHome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadResidentHome(@RequestParam final CommonsMultipartFile file) {
		if (file != null) {
			final String originalFilename = file.getOriginalFilename();
			final Documents samename = docRepo.findByName(originalFilename);
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {
				final File uploadedFile = new File(String.format("%s/%s", RESIDENT_HOME_DIRECTORY, file.getOriginalFilename()));
				log.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(StringUtils.delete(uploadedFile.getPath(), "/home/ashtones"));
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.RESIDENT_HOMES);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					log.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping(value = "/admin/uploadPublicTownhome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadPublicTownhome(@RequestParam final CommonsMultipartFile file) {

		if (file != null) {
			final String originalFilename = file.getOriginalFilename();
			final Documents samename = docRepo.findByName(originalFilename);
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {
				final File uploadedFile = new File(String.format("%s/%s", PUBLIC_TOWNHOME_DIRECTORY, file.getOriginalFilename()));

				log.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(StringUtils.delete(uploadedFile.getPath(), "/home/ashtones"));
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.PUBLIC_TOWNHOME);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					log.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@PostMapping(value = "/admin/uploadResidentTownhome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadResidentTownhome(@RequestParam final CommonsMultipartFile file) {
		if (file != null) {
			final String originalFilename = file.getOriginalFilename();
			final Documents samename = docRepo.findByName(originalFilename);
			if (samename != null) {
				// should not have 2 with same name so return Conflict status
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body(JSONObject.toJSONString(Collections.singletonMap("error", "Filename already exists, please rename this one or delete old one and try again.")));
			} else {

				final File uploadedFile = new File(String.format("%s/%s", RESIDENT_TOWNHOME_DIRECTORY, file.getOriginalFilename()));

				log.info("Saving file to: {}", uploadedFile);
				try {
					file.transferTo(uploadedFile);
					final Documents doc = new Documents();
					doc.setName(file.getOriginalFilename());
					doc.setPath(StringUtils.delete(uploadedFile.getPath(), "/home/ashtones"));
					doc.setSize(file.getSize());
					doc.setUploadedDate(new Date().toString());
					doc.setDocumentType(DocumentType.RESIDENT_TOWNHOME);
					docRepo.save(doc);
				} catch (IllegalStateException | IOException e) {
					log.error("{}", e.getMessage());
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONObject.toJSONString(Collections.singletonMap("error", e.getMessage())));
				}
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}