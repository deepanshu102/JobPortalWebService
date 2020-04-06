package org.deep.bitsbytes.controller;

import java.sql.Date;
import java.util.List;

import org.deep.bitsbytes.model.Application;
import org.deep.bitsbytes.model.Job;
import org.deep.bitsbytes.repository.ApplicationRepository;
import org.deep.bitsbytes.repository.JobRepository;
import org.deep.bitsbytes.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private ApplicationRepository applicationRepo;

	@GetMapping
	public List<Application> viewApplication() {
		return applicationRepo.findAll();
		
	}

	@PostMapping("/{jobId}")
	public Application appliedJob() {

		Application entity = new Application();
		entity.setJobSeeker(jobSeekerRepository.findById(1).get());
		entity.setJobId(jobRepository.findById(1).get());
		entity.setStatus(false);
		entity.setAppliedDate(new Date(10, 20, 1997));

		return applicationRepo.save(entity);
	}

}
