package org.deep.bitsbytes.controller;

import java.util.List;
import java.util.Map;

import org.deep.bitsbytes.model.EducationCategory;
import org.deep.bitsbytes.repository.EducationCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educationcat")
public class EducationCategoryController {

	@Autowired
	private EducationCategoryRepository educationCategoryRepo;

	// Display EducationCategory
	@GetMapping
	public List<EducationCategory> index() {
//		Map<String,Map<String,>
		return educationCategoryRepo.findAll();
		// educationRepo.findAll();
	}

	// Saving EducationCategory
	@PostMapping
	public EducationCategory saveEducationCat(@RequestBody Map<String, String> educationCatBody) {
		return educationCategoryRepo.save(new EducationCategory(educationCatBody.get("text")));
	}

	// DeleteEducationCategory
	@DeleteMapping("/{id}")
	public String deleteEducationCat(@PathVariable String id) {
		Integer identity = Integer.parseInt(id);

		try {
			educationCategoryRepo.deleteById(identity);

			return "Sucessfully Deleted";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// for Update
	@PutMapping("/{id}")
	public EducationCategory updateEducationCat(@PathVariable String id, @RequestBody Map<String, String> title) {
		Integer identity = Integer.parseInt(id);
		EducationCategory educationCategory = null;
		try {
			educationCategory = educationCategoryRepo.findById(identity).get();
			educationCategory.setEducationCategoryName(title.get("text"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return educationCategoryRepo.save(educationCategory);
	}

}
