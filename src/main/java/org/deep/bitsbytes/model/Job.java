package org.deep.bitsbytes.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String jobTitle;
	private String offerSalary;
	private int vacancy;
	private String type;
	private String descriptions;
	private String advertiseDate;
	private String expDate;
	private String experience;
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobId")
//	private Set<Application> applicationSet;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String jobTitle, String offerSalary, int vacancy, String type, String descriptions, String advertiseDate,
			String expDate) {
		super();
		this.jobTitle = jobTitle;
		this.offerSalary = offerSalary;
		this.vacancy = vacancy;
		this.type = type;
		this.descriptions = descriptions;
		this.advertiseDate = advertiseDate;
		this.expDate = expDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOfferSalary() {
		return offerSalary;
	}

	public void setOfferSalary(String offerSalary) {
		this.offerSalary = offerSalary;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getAdvertiseDate() {
		return advertiseDate;
	}

	public void setAdvertiseDate(String advertiseDate) {
		this.advertiseDate = advertiseDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

//	public Set<Application> getApplicationSet() {
//		return applicationSet;
//	}
//
//	public void setApplicationSet(Set<Application> applicationSet) {
//		this.applicationSet = applicationSet;
//	}
}
