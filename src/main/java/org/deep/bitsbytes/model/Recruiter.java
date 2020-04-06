package org.deep.bitsbytes.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recruiter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String companyName;
	private String companyAddress;
	private String companyType;
	private String companyDescription;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="recruiter_id")
	private Set<Job> postedJob;
	
	

	public Set<Job> getPostedJob() {
		return postedJob;
	}

	public void setPostedJob(Set<Job> postedJob) {
		this.postedJob = postedJob;
	}

	public Recruiter(String companyName, String companyAddress, String companyType, String companyDescription,
			User user) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyType = companyType;
		this.companyDescription = companyDescription;
		this.user = user;
	}

	public Recruiter(String companyName, String companyAddress, String companyType, String companyDescription) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyType = companyType;
		this.companyDescription = companyDescription;
	}
	
	

	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recruiter(Integer id, String companyName, String companyAddress, String companyType,
			String companyDescription, User user) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyType = companyType;
		this.companyDescription = companyDescription;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	
	
	
}
