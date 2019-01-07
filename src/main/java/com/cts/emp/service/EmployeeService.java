package com.cts.emp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.emp.model.Employee;
import com.cts.emp.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeRepository {

	@Override
	public List<Employee> getAllEmpoyees(){
		List<Employee> employees = Arrays.asList(
                new Employee( 1, "Sri",Arrays.asList("12342435", "768797978987")),
                new Employee( 2, "Sam",Arrays.asList("87987987", "87987", "456237891")),
                new Employee( 3, "Venu", Arrays.asList("342535")),
                new Employee( 4, "Sathvik",Arrays.asList("342535", "23466765"))
        );
		return employees;
	}
	
}
