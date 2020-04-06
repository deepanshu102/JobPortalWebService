package org.deep.bitsbytes.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.deep.bitsbytes.model.JobSeeker;
import org.deep.bitsbytes.model.Skills;
import org.deep.bitsbytes.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/skills")
@RestController
public class SkillsContoller {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	@GetMapping
	public List<JobSeeker> viewSkills()
	{
		return jobSeekerRepository.findAll();
	}
	
	@PostMapping("/{id}")
	public JobSeeker addSkill(@PathVariable String id,@RequestBody Map<String,String> body)
	{
		String name=body.get("name");
		String type=body.get("type");
		Integer jId=Integer.parseInt(id);
		JobSeeker entity=jobSeekerRepository.findById(jId).get();

		Skills skills=new Skills();
		skills.setName(name);
		skills.setType(type);
		entity.getSkillSet().add(skills);
		return jobSeekerRepository.save(entity);
	}
	@PutMapping("/{id}")
	public JobSeeker updateSkill(@PathVariable String id,@RequestBody Map<String,String> body)
	{
		String name=body.get("name");
		String type=body.get("type");
		Integer jId=Integer.parseInt(id);
		JobSeeker entity=jobSeekerRepository.findById(jId).get();
	
		Skills skills=new Skills();

		skills.setName(name);
		skills.setType(type);		
		Set<Skills> skillSet=jobSeekerRepository.findById(jId).get().getSkillSet();
		System.out.println(skillSet.remove(skills));
			skillSet.add(skills);
		
		
		entity.setSkillSet(skillSet);
		return jobSeekerRepository.save(entity);
	}

	
 }
