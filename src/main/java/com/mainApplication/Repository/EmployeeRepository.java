package com.mainApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainApplication.Entity.Employee;
//We don't to add @repository in this b'coz JPA will take care for this...
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
}
