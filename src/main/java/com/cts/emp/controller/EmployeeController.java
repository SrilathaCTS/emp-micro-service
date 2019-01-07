package com.cts.emp.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.emp.model.Employee;
import com.cts.emp.repository.EmployeeRepository;
 
@RestController
@Configuration
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	public EmployeeRepository repository; 
	
	/*returns all the employees*/
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> getAllEmpoyees(){
		return repository.getAllEmpoyees();
	}
	
	/*returns employee based on request id*/
	@RequestMapping(value = "/getEmpoyeeById", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Stream<Employee> getEmpoyeeById(@RequestParam int id){
		return  repository.getAllEmpoyees().stream().filter(emp -> emp.getEmpId() == id);
	}
	
	/*returns the employee list  whose name starting with req string (ex: s)  */
	@RequestMapping(value = "/getAllNamesStartWith", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> getNamesStartWith(@RequestParam String name){
		return  repository.getAllEmpoyees().stream().filter(emp ->  emp.getEmpName().startsWith(name)).collect(Collectors.toList());
	}
 
	/*returns employee learning list*/
	@RequestMapping(value = "/getLearningList")
	  public String readingList(){
	    return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	  }
}
