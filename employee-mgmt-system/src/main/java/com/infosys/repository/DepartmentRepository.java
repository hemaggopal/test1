package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
