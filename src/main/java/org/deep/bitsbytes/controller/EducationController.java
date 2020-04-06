package org.deep.bitsbytes.controller;

import java.util.List;
import java.util.Map;

import org.deep.bitsbytes.model.Education;
import org.deep.bitsbytes.model.EducationCategory;
import org.deep.bitsbytes.repository.EducationCategoryRepository;
import org.deep.bitsbytes.repository.EducationRepository;
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
@RequestMapping("/education")
public class EducationController {
	@Autowired
	private EducationRepository educationRepo;
	@Autowired
	private EducationCategoryRepository educationCatRepo;
	

	@GetMapping
	public List<Education> educationView() {

		return educationRepo.findAll();
	}
	@PostMapping
	public Education saveEducation(@RequestBody Map<String ,String >body)
	{
		EducationCategory educationCat=educationCatRepo.findByEducationCategoryName(body.get("catname"));
		
		Education education=new Education();
		education.setCourse(body.get("course"));
		education.setCourseType(body.get("coursetype"));
		education.setPassingYear(body.get("passingyear"));
		education.setSpecialisation(body.get("specialisation"));
		education.setUniversity(body.get("university"));
		education.setEducationCategory(educationCat);
		//Its automatically insert the record in education table and map with this object of EducationCategory
		return educationRepo.save(education);
	}

	@PutMapping("/{id}")
	public Education updateEducation(@PathVariable String id,@RequestBody Map<String,String> body)
	{
		Integer eduIdentity=Integer.parseInt(id);
		String course=body.get("course");
		String courseType=body.get("coursetype");
		String passingYear=body.get("passingyear");
		String specialisation=body.get("specialisation");
		String university=body.get("university");
		Education educationObj=educationRepo.findById(eduIdentity).get();
			educationObj.setCourse(course);
			educationObj.setCourseType(courseType);
			educationObj.setSpecialisation(specialisation);
			educationObj.setPassingYear(passingYear);
			educationObj.setUniversity(university);
		return educationRepo.save(educationObj);
	}
	
	@DeleteMapping("/{identity}")
	public String deleteEducation(@PathVariable String identity)
	{
		String status;
		try {
			Integer id=Integer.parseInt(identity);
			educationRepo.deleteById(id);
			status="Successfully Deleted";
		}
		catch(Exception e)
		{
			status=e.getMessage();
		}
		return status;
	}
	
	

}
