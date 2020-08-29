package com.infosys.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.learning.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
