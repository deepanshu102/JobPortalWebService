package org.deep.bitsbytes.controller;

import java.util.List;
import java.util.Map;

import org.deep.bitsbytes.model.Job;
import org.deep.bitsbytes.model.Recruiter;
import org.deep.bitsbytes.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postJob")
public class JobController {

	@Autowired
	private RecruiterRepository recruiterRepo;

	@GetMapping
	public List<Recruiter> viewPostedJob() {
		return recruiterRepo.findAll();
	}

	@PostMapping("/{id}")
	public Recruiter postJob(@PathVariable String id, @RequestBody Map<String, String> body) {
		Recruiter recruiter = null;
		try {
			Integer identity = Integer.parseInt(id);
			recruiter = recruiterRepo.findById(identity).get();

			String jobTitle = body.get("jobTitle");
			String advertiseDate = body.get("advertiseDate");
			String descriptions = body.get("descriptions");
			String experience = body.get("experience");
			String expDate = body.get("expDate");
			String offerSalary = body.get("offerSalary");
			String type = body.get("type");
			Integer vacancy = Integer.parseInt(body.get("vacancy"));

			Job postedJob = new Job();
			postedJob.setJobTitle(jobTitle);
			postedJob.setType(type);
			postedJob.setOfferSalary(offerSalary);
			postedJob.setVacancy(vacancy);
			postedJob.setAdvertiseDate(advertiseDate);
			postedJob.setExpDate(expDate);
			postedJob.setDescriptions(descriptions);
			postedJob.setExperience(experience);
			recruiter.getPostedJob().add(postedJob);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return recruiterRepo.save(recruiter);
	}

//	@PutMapping("/{id}")
//	public Recruiter updatePostedJob(@PathVariable String id,@RequestBody Map<String,String> body)
//	{
//		Recruiter recruiter=null;
//		try {
//		Integer identity=Integer.parseInt(id);
//	 recruiter=recruiterRepo.findById(identity).get();
//		
//		String jobTitle=body.get("jobTitle");	
//		String advertiseDate=body.get("advertiseDate");
//		String descriptions=body.get("descriptions");
//		String experience=body.get("experience");
//		String expDate=body.get("expDate");
//		String offerSalary=body.get("offerSalary");
//		String type=body.get("type");
//		Integer vacancy=Integer.parseInt(body.get("vacancy"));
//		
//		Job postedJob = new Job();
//		postedJob.setJobTitle(jobTitle);
//		postedJob.setType(type);
//		postedJob.setOfferSalary(offerSalary);
//		postedJob.setVacancy(vacancy);
//		postedJob.setAdvertiseDate(advertiseDate);
//		postedJob.setExpDate(expDate);
//		postedJob.setDescriptions(descriptions);
//		postedJob.setExperience(experience);
//		
//		// Instead of ADD we check first is Exist or not
//		recruiter.getPostedJob().add(postedJob);
//		
//	
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		return recruiterRepo.save(recruiter);
//	}

}
