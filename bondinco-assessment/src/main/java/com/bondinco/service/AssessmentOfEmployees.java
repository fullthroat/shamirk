package com.bondinco.service;

import java.util.List;

import com.bondinco.data.Assessment;
import com.bondinco.data.Employee;

public class AssessmentOfEmployees extends Assessment{
	
	private List<Employee> employees;

	public AssessmentOfEmployees(Assessment assessment, List<Employee> employees) {
		super(assessment.getFirstName(), assessment.getLastName(), assessment.getJoiningYear(), 
				assessment.getDepartment(), assessment.getAssessments(), assessment.getPassFail());
		
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

	
}
