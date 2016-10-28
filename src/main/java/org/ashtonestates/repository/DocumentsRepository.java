package org.ashtonestates.repository;

import java.util.List;

import org.ashtonestates.model.DocumentType;
import org.ashtonestates.model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DocumentsRepository extends JpaRepository<Documents, Long> {

	List<Documents> findByDocumentType(DocumentType docType);

	Documents findByName(String filename);

	Documents findByPath(String path);
}
