package com.bondinco.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bondinco.data.Employee;

@FeignClient("employeedata")
public interface EmployeeDataClient {
	
	@RequestMapping(method = RequestMethod.GET, value="/employeedata/{id}")
	List<Employee> getEmployee(@PathVariable("id") String employeeId);

}
