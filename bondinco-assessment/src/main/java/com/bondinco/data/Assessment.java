package com.bondinco.data;

import java.util.List;

public class Assessment {

	private String id;
	private String firstName;
	private String lastName;
	private String joiningYear;
	private String department;
	private String passFail;

	private List<String> assessments;

	public Assessment(String firstName, String lastName, String joiningYear, String department,
			List<String> assessments, String passFail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.joiningYear = joiningYear;
		this.department = department;
		this.assessments = assessments;
		this.passFail = passFail;
	}

	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJoiningYear() {
		return joiningYear;
	}

	public void setJoiningYear(String joiningYear) {
		this.joiningYear = joiningYear;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<String> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<String> assessments) {
		this.assessments = assessments;
	}

	public String getPassFail() {
		return passFail;
	}

	public void setPassFail(String passFail) {
		this.passFail = passFail;
	}

}
