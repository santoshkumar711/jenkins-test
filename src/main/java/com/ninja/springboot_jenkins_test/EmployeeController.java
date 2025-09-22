package com.ninja.springboot_jenkins_test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	
	@Autowired
	EmployeeRepository erepo;
	@RequestMapping("/test")
	public String test()
	{
		return "this is jenkins test ";
	}
	@RequestMapping("/test1")
	public String test1()
	{
		return "this is jenkins test2 ";
	}
	
	@RequestMapping("/save")
	public String save(@RequestBody Employee employee)
	{
		erepo.save(employee);
		return "data saved into table";
	}
	@RequestMapping("/all")
	public List<Employee> alldata()
	{
		return erepo.findAll();
	}
	@PutMapping("/update/{id}")
	public Employee update(@RequestBody Employee employee,@PathVariable int id)
	{
		Employee emp=erepo.findById(id).get();
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}
	@DeleteMapping("/del/{id}")
	public String delbyid(@PathVariable int id)
	{
		erepo.deleteById(id);
		return "data deleted";
	}
}

