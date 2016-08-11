package com.bondinco.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bondinco.data.Assessment;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
public class AssessmentService implements CommandLineRunner {

	private static List<Assessment> assessments = new ArrayList<Assessment>();
	@Autowired
	private EmployeeDataClient employeeClient;

	public static void main(String[] args) {
		SpringApplication.run(AssessmentService.class, args);
	}

	@RequestMapping("/")
	public List<Assessment> getAssessments() {
		return assessments;
	}

	@RequestMapping("/assessments/{id}")
	public List<Assessment> getAssessments(@PathVariable String id) {
		return assessments.stream().filter(p -> p.getAssessments().contains(id)).collect(Collectors.toList());
	}
	
	@RequestMapping("/participants")	
	public List<AssessmentOfEmployees> getAssessmentsWithEmployees(){
		
		List<AssessmentOfEmployees> returnedAssessments=new ArrayList<AssessmentOfEmployees>();
		for(Assessment assessment:assessments){
			returnedAssessments.add(new AssessmentOfEmployees(assessment,employeeClient.getEmployee(assessment.getId())));
		}
		
		return returnedAssessments;
		
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		assessments.add(new Assessment("Kazim", "Abidi", "2016", "Technology", Arrays.asList("1234", "5678"), "Pass"));
		assessments
				.add(new Assessment("Abdul", "Hafeez", "2015", "Technology", Arrays.asList("786", "123457"), "Pass"));

	}
}
