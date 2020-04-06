package org.deep.bitsbytes.repository;

import org.deep.bitsbytes.model.EducationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationCategoryRepository extends JpaRepository<EducationCategory, Integer> {

	EducationCategory findByEducationCategoryName(String educationCategory);

}
