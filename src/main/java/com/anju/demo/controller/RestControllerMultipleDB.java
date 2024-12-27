package com.anju.demo.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anju.demo.h2.model.Employee;
import com.anju.demo.h2.repository.EmployeeRepository;
import com.anju.demo.mysql.model.Skill;
import com.anju.demo.mysql.repository.SkillRepository;

@RestController
@RequestMapping("/")
public class RestControllerMultipleDB {
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private SkillRepository skillRepo;
	
	@PostConstruct
	public String save() {
		/*
		 * Fill in data to database as each time application restarts the data in H2 is lost
		 * PostConstruct will be called each time the application is loaded 
		 * */
		//Save to H2
		Employee emp = new Employee(100, "Anju");
		empRepo.save(emp);
		
		//Save to Mysql
		Skill skill = new Skill(11, "Multi DB Support", 1);
		skillRepo.save(skill);
		
		return "Saved Successfully..";
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Anju";
	}

	@GetMapping("/getEmployee")
	public Optional<Employee> getEmployee() {
		System.out.println("emloyee..");
		Optional<Employee> e = empRepo.findById(100);
		System.out.println(e);
		return e;
	}
	
	@Bean(name="emp1")
	public Employee getEmployee1() {
		return new Employee(1, "Anju Prema");
	}
	
	@Bean(name="emp2")
	public Employee getEmployee2() {
		return new Employee(2, "Paru Kutty");
	}
	
	@GetMapping("/getEmployeeUsingQualifier")
	public Employee getEmployee(@Qualifier("emp1") Employee emp) {
		System.out.println(emp);
		return emp;
	}
	
}
