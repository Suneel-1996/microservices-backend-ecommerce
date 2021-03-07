package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;


import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	//below resource sends all employees
	@GetMapping(path="/employees")
	//,produces = {"application/json","application/xml"}
	public List<Employee> getAllEmployees(){
		
		return employeeRepo.findAll(); 
		
	}
	
	//below resource creates emloyees,consumes = {"MediaType.APPLICATION_JSON","MediaType.APPLICATION_XML"}
	@PostMapping(path="/employee",consumes = {"application/json","application/xml"})
	public Employee addEmployee(@RequestBody Employee emp) {
		
		return employeeRepo.save(emp);
	}
	
	//below resource gets employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") long id) {
		Employee e=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: "+id));
		return ResponseEntity.ok(e);
		
	}
	
	//below service deletes emplyee data by id
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable(name = "id") long id) {
		employeeRepo.deleteById(id);
	}
	//below resource updates the employee
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name="id") long id,@RequestBody Employee e) {
		
		if(employeeRepo.existsById(id)) {
			Employee existing=employeeRepo.findById(id).orElse(new Employee());
			existing.setId(id);
			existing.setEmailId(e.getEmailId());
			existing.setFirstName(e.getFirstName());
			existing.setLastName(e.getLastName());
			employeeRepo.save(existing);
			return ResponseEntity.ok(existing);
			
		}
		else {
			employeeRepo.save(e);
			return ResponseEntity.ok(e);
		}
		
		
	}
}
