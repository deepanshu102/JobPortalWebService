package org.deep.bitsbytes.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date appliedDate;
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job jobId;

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private JobSeeker jobSeeker;

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(Integer id, Date appliedDate, boolean status, Job jobId, JobSeeker jobSeeker) {
		super();
		this.id = id;
		this.appliedDate = appliedDate;
		this.status = status;
		this.jobId = jobId;
		this.jobSeeker = jobSeeker;
	}

	public Application(Date appliedDate, boolean status, Job jobId, JobSeeker jobSeeker) {
		super();
		this.appliedDate = appliedDate;
		this.status = status;
		this.jobId = jobId;
		this.jobSeeker = jobSeeker;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Job getJobId() {
		return jobId;
	}

	public void setJobId(Job jobId) {
		this.jobId = jobId;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

}
