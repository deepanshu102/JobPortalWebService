package org.deep.bitsbytes.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date dob;
	private String location;
	private String address;

	//cascade = CascadeType.ALL we can't use this because if we use and  user delete Education details Delete our record delete
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "jobSeeker")
	private Set<Education> educationSet;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "jobSeeker")
	private Set<Skills> skillSet;
//
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobSeeker")
//	private Set<Application> appliedApplicationSet;
//	
	
	

	
//	public Set<Application> getAppliedApplicationSet() {
//		return appliedApplicationSet;
//	}
//
//	public void setAppliedApplicationSet(Set<Application> appliedApplicationSet) {
//		this.appliedApplicationSet = appliedApplicationSet;
//	}

	public Set<Skills> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(Set<Skills> skillSet) {
		this.skillSet = skillSet;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Education> getEducationSet() {
		return educationSet;
	}

	public void setEducationSet(Set<Education> educationSet) {
		this.educationSet = educationSet;
	}

	public JobSeeker(Date dob, String location, String address, Integer id) {
		super();
		this.dob = dob;
		this.location = location;
		this.address = address;
		this.id = id;
	}

	public JobSeeker() {
		// TODO Auto-generated constructor stub
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
