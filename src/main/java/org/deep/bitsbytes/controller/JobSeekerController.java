package org.deep.bitsbytes.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.deep.bitsbytes.model.Education;
import org.deep.bitsbytes.model.EducationCategory;
import org.deep.bitsbytes.model.JobSeeker;
import org.deep.bitsbytes.model.User;
import org.deep.bitsbytes.repository.EducationCategoryRepository;
import org.deep.bitsbytes.repository.JobSeekerRepository;
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
@RequestMapping("/jobseeker")
public class JobSeekerController {

	@Autowired
	private JobSeekerRepository jobSeekerRepo;
	@Autowired
	private EducationCategoryRepository educationCatRepo;
	
//	@Autowired
//	private UserRepository userRepo;

	@GetMapping
	public List<JobSeeker> viewJobSeeker() {
		return jobSeekerRepo.findAll();
	}

	@PostMapping
	public JobSeeker saveJobSeeker(@RequestBody Map<String, String> body) {

		User user = new User();

		JobSeeker entity = null;
		String address = body.get("address");
		String email = body.get("email");
		String dob = body.get("dob");
		String firstName = body.get("firstname");
		String lastName = body.get("lastname");
		String location = body.get("location");
		String password = body.get("password");
		try {
			entity = new JobSeeker();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password);
			entity.setAddress(address);
			entity.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
			entity.setLocation(location);
			entity.setUser(user);
		} catch (Exception e) {

		}
		return jobSeekerRepo.save(entity);
	}

	@PutMapping("/{id}")
	public JobSeeker updateJobSeeker(@PathVariable("id") String id, @RequestBody Map<String, String> body) {
		String address = body.get("address");
		String email = body.get("email");
		String dob = body.get("dob");
		String firstName = body.get("firstname");
		String lastName = body.get("lastname");
		String location = body.get("location");
		User user = null;
		JobSeeker entity = null;

		try {
			entity = jobSeekerRepo.findById(Integer.parseInt(id)).get();
			user = entity.getUser();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			entity.setAddress(address);
			entity.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(dob));
			entity.setLocation(location);
		} catch (Exception e) {

		}
		return jobSeekerRepo.save(entity);
	}

	@DeleteMapping("/{id}")
	public boolean deleteJobSeeker(@PathVariable String id) {
		jobSeekerRepo.deleteById(Integer.parseInt(id));
		return true;
	}

	@PostMapping("/{id}")
	public JobSeeker addEducation(@PathVariable String id, @RequestBody Map<String, String> body) {
		JobSeeker entity = jobSeekerRepo.findById(Integer.parseInt(id)).get();
		
		Education education = new Education();
		

		
		String catname = body.get("catname");
		String course = body.get("course");
		String courseType = body.get("courseType");
		String specialisation = body.get("specialisation");
		String university = body.get("university");
		String passingYear = body.get("passingYear");

		EducationCategory educationCategory=educationCatRepo.findByEducationCategoryName(catname);
		System.out.println(educationCategory.getEducationCategoryName());
		education.setEducationCategory(educationCategory);
		education.setCourseType(courseType);
		education.setCourse(course);
		education.setPassingYear(passingYear);
		education.setUniversity(university);
		education.setSpecialisation(specialisation);
		entity.getEducationSet().add(education);
		
		return jobSeekerRepo.save(entity);
	}

	
	
}
