package com.anju.demo.h2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anju.demo.h2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
