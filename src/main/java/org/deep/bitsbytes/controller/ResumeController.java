package org.deep.bitsbytes.controller;

import java.util.List;
import java.util.Map;

import org.deep.bitsbytes.model.JobSeeker;
import org.deep.bitsbytes.model.Resume;
import org.deep.bitsbytes.repository.JobSeekerRepository;
import org.deep.bitsbytes.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	private JobSeekerRepository jobSeekerRepo;
	@Autowired
	private ResumeRepository resumeRepo;
	
	@GetMapping
	public List<JobSeeker> resumeView()
	{
			return jobSeekerRepo.findAll();
	}
	
	@PostMapping("/{jobSeekerId}")
	public JobSeeker addResume(@PathVariable String jobSeekerId,@RequestBody Map<String,String> body) {
		String fileName=body.get("filename");
		String fileType=body.get("filetype");
		
		Resume resume=new Resume();
		resume.setFileName(fileName);
		resume.setFileType(fileType);
		JobSeeker jobSeeker=jobSeekerRepo.findById(Integer.parseInt(jobSeekerId)).get();
		
		jobSeeker.setResume(resume);
		
		return jobSeekerRepo.save(jobSeeker);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteResume(@PathVariable String id)
	{
		try {
		Integer identity=Integer.parseInt(id);
		System.out.println(identity);
	    JobSeeker jobSeeker=jobSeekerRepo.findById(identity).get();
	   
	    Resume resume=jobSeeker.getResume();
	    resumeRepo.deleteById(resume.getId());
	    jobSeekerRepo.save(jobSeeker);
	    return jobSeeker.getAddress()+" "+jobSeeker.getLocation();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	    
	}
}
