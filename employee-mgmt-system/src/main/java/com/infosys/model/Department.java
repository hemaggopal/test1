package com.infosys.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long departmentId;
	private String departmentName;

	/*
	 * @OneToMany(mappedBy="department") private List<Employee> employees;
	 */
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(long departmentId, String departmentName) {//, List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		//this.employees = employees;
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/*
	 * public List<Employee> getEmployees() { return employees; } public void
	 * setEmployees(List<Employee> employees) { this.employees = employees; }
	 */
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName ;//+ ", employees="+ employees + "]";
	}
}