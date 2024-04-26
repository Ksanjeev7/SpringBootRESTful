package com.mainApplication.Service;

import java.util.List;

import com.mainApplication.Entity.Employee;

public interface EmployeeService {
  Employee saveEmployee(Employee emp);
  List<Employee> getAllEmployees();
   Employee getEmployeeById(int Id);
   Employee UpdateEmployee(Employee emp, int Id);
   void deleteEmployee(int Id);
}
