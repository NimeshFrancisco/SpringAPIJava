package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Salary;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SalaryRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
	}; 
	
	//get all employees
		@GetMapping("/salaries")
		public List<Salary> getAllSalaries(){
			
			return salaryRepository.findAll();
		}; 
		
		//get paid employees
		@GetMapping("/paidemployees")
		public List<Employee> getpaidemployees(){
			return employeeRepository.getPaidEmployees();
		}; 
		
		@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee>  getEmployeeById(@PathVariable Long id) {
			Employee employee=employeeRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Eployee found by this id"+id));
			return ResponseEntity.ok(employee);
		
		}
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee>  updateEmployeeById(@PathVariable Long id,@RequestBody Employee employeeDetailes) {
			Employee employee=employeeRepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Eployee found by this id"+id));
			employee.setFirstName(employeeDetailes.getFirstName());
			employee.setLastName(employeeDetailes.getLastName());
			employee.setEmailId(employeeDetailes.getEmailId());
			
			Employee updateEmployee = employeeRepository.save(employee);		
			return ResponseEntity.ok(updateEmployee);
		
		}
		
		
		  @DeleteMapping("/employees/{id}")
		  public Map<String,Boolean> deleteEmployeeById(@PathVariable Long id) { 
			  Employee employee=employeeRepository.findById(id) .orElseThrow(()-> new
			  ResourceNotFoundException("Eployee found by this id"+id));
			  employeeRepository.delete(employee); 
			  Map<String, Boolean> response = new HashMap<>();
			  response.put("delete",Boolean.TRUE);
			  return response;
		  
		  }
		 
	
}
