package org.deep.bitsbytes.controller;

import java.util.List;
import java.util.Map;

import org.deep.bitsbytes.model.Recruiter;
import org.deep.bitsbytes.model.User;
import org.deep.bitsbytes.repository.RecruiterRepository;
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
@RequestMapping("/recruiter")
public class RecruiterController {

	@Autowired
	RecruiterRepository recruiterRepo;

	@GetMapping
	public List<Recruiter> viewRecruiter() {
		return recruiterRepo.findAll();
	}

	@PostMapping
	public Recruiter saveJobSeeker(@RequestBody Map<String, String> body) {

		User user = new User();

		Recruiter entity = null;
		String firstName = body.get("firstName");
		String lastName = body.get("lastName");

		String companyAddress = body.get("companyAddress");
		String email = body.get("email");
		String companyName = body.get("companyName");
		String companyType = body.get("companyType");
		String companyDescription = body.get("description");
		String password = body.get("password");
		try {
			entity = new Recruiter();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password);
			entity.setCompanyDescription(companyDescription);
			entity.setCompanyName(companyName);
			entity.setCompanyType(companyType);
			entity.setCompanyAddress(companyAddress);

			entity.setUser(user);
		} catch (Exception e) {

		}
		return recruiterRepo.save(entity);
	}

	@DeleteMapping("/{id}")
	public boolean deleteJobSeeker(@PathVariable String id) {
		recruiterRepo.deleteById(Integer.parseInt(id));
		return true;
	}

	@PutMapping("/{id}")
	public Recruiter updateRecruiter(@PathVariable String id, @RequestBody Map<String, String> body) {
		User user = null;

		Recruiter entity = recruiterRepo.findById(Integer.parseInt(id)).get();
		String firstName = body.get("firstName");
		String lastName = body.get("lastName");

		String companyAddress = body.get("companyAddress");
		String email = body.get("email");
		String companyName = body.get("companyName");
		String companyType = body.get("companyType");
		String companyDescription = body.get("description");
		String password = body.get("password");
		try {
			user=entity.getUser();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password);
			entity.setCompanyDescription(companyDescription);
			entity.setCompanyName(companyName);
			entity.setCompanyType(companyType);
			entity.setCompanyAddress(companyAddress);

			entity.setUser(user);
		} catch (Exception e) {

		}
		return recruiterRepo.save(entity);
	}

}
