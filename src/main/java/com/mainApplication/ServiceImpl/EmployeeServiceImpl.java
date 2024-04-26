package com.mainApplication.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mainApplication.Entity.Employee;
import com.mainApplication.Exception.ResourceNotFoundException;
import com.mainApplication.Repository.EmployeeRepository;
import com.mainApplication.Service.EmployeeService;

@Service// It's Important to annotate when we create service class
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepository;
	
	
	//Constructor based DI....
	//Here @Autoweird Annotation not required when we have single Constructor, Spring automatically inject it..
	public EmployeeServiceImpl(EmployeeRepository empRepository) {
		super();
		this.empRepository = empRepository;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		//saving Employee in the Database
		return  empRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		 return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int Id) {
            Optional<Employee> empId = empRepository.findById(Id);
            //check the empId is exits or not in the table...
            if(empId.isPresent()) {
            	return  empId.get();
            }else {
             throw new ResourceNotFoundException("Employee", "Id", Id);
            }
	}

	@Override
	public Employee UpdateEmployee(Employee emp, int Id) {
		// check whether the EmpId is exist or not in DB using Lambda Function.
		Employee existingEmp = empRepository.findById(Id).orElseThrow( () 
				                                    -> new ResourceNotFoundException("Employee", "Id", Id)  );// lambda function ..
		existingEmp.setFirstName(emp.getFirstName());
		existingEmp.setLastName(emp.getLastName());
		existingEmp.setEmail(emp.getEmail());
		//save the Update Employee to DB
		empRepository.save(existingEmp);
		return existingEmp;
	}

	@Override
	public void deleteEmployee(int empId) {
		//check whether empId exists in DB or not with lambda fuunction
	empRepository.findById(empId).orElseThrow(  () -> new ResourceNotFoundException("Employee", "Id", empId));
	//delete the emp through Id
	empRepository.deleteById(empId);
		
	}

}
