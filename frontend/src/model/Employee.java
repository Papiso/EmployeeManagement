package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.EmployeeEntity;

@ManagedBean(name = "employee")
@SessionScoped
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surName;
	private Date dateOfBirth;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public EmployeeEntity getEntity()
	{
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setDateOfBirth(dateOfBirth);
		employeeEntity.setName(name);
		employeeEntity.setSurName(surName);
		return employeeEntity;
	}
	
	public Employee getEmployee(EmployeeEntity employeeEntity) {
		Employee employee = new Employee();
		employee.setName(employeeEntity.getName());
		employee.setSurName(employeeEntity.getSurName());
		employee.setDateOfBirth(employeeEntity.getDateOfBirth());
		return employee;
	}
	
	public List<Employee> getEmployees(List<EmployeeEntity> employeeEntityList){
		List<Employee> employeeList = new ArrayList<>();
		for(EmployeeEntity empEntity : employeeEntityList) {
			Employee employee = new Employee();
			employee = getEmployee(empEntity);
			employeeList.add(employee);
		}
		return employeeList;
	}
	
	

}
