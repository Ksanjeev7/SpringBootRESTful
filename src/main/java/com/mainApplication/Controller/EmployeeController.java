package com.mainApplication.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainApplication.Entity.Employee;
import com.mainApplication.Service.EmployeeService;

@RestController    //By using this Annotation ,, we can eliminate @responseBody on each reqHandling method..
@RequestMapping("/employees")
public class EmployeeController {

	//It's a interface which gives all methods to perform CRUD Operations..
	private EmployeeService empSer;

	public EmployeeController(EmployeeService empSer) {
		super();
		this.empSer = empSer;
	}
	//build create employee REST Api
	@PostMapping
	public  ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		// Check if firstName is not null
        if (emp.getFirstName() == null) {
            return ResponseEntity.badRequest().build(); // Return a 400 Bad Request response
        }
		 return new ResponseEntity<Employee>(empSer.saveEmployee(emp), HttpStatus.CREATED);
	}

	//Build getall Employees REST API...
	@GetMapping
  public List<Employee> getAllEmployees(){
		return empSer.getAllEmployees();
	}
	//build getempbyId REST API
	//URL path: http://localhost:8080/employees/1
	@GetMapping("{Id}")
	public  ResponseEntity<Employee> getEmployeeById( @PathVariable("Id") int empId){
		 return new ResponseEntity<Employee>(empSer.getEmployeeById(empId), HttpStatus.OK);
	}
	//build Update EmployeeById RESTAPI
	 @PutMapping("{id}")
	 public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int Id
			      ,@RequestBody Employee emp)  {// By req we get Json object to convert java wu use @ReBody
		 
		 return new ResponseEntity<Employee>(empSer.UpdateEmployee(emp, Id),HttpStatus.OK);
	 }
	 
	 //Delete the Employee using RESTAPI
	//https://localhost:8080/employees/1
	 @DeleteMapping("{id}")
	 public ResponseEntity<String> deleteEmployee(@PathVariable("id") int Id){
		 //delete employee from DB
		 empSer.deleteEmployee(Id);
		 return  new ResponseEntity<String>("Deleted Successfully !", HttpStatus.OK);
	 }
	 
}
