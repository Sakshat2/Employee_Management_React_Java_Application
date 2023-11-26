package my.seven.springbootbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.seven.springbootbackend.exception.ResourceNotFoundException;
import my.seven.springbootbackend.model.Employee;
import my.seven.springbootbackend.repository.EmployeeRepository;




@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
		
	}
	//build create employee rest api 
	@PostMapping
	public Employee  createEmployee( @RequestBody Employee employee) {
		 return employeeRepository.save(employee);
	}
	
	
	//build get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found" +id));
	
		return ResponseEntity.ok(employee);
	}
	
	
	//build update employee REST API 
//    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
    @PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
		
		Employee updatEmployee= employeeRepository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id:" +id));
		
		updatEmployee.setFirstName(employeeDetails.getFirstName());
		updatEmployee.setLastName(employeeDetails.getLastName());
		updatEmployee.setEmailId(employeeDetails.getEmailId());
		employeeRepository.save(updatEmployee);
		return ResponseEntity.ok(updatEmployee);
		
	}
    //delete api 
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
    	
    	Employee employee =employeeRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" +id));
    	employeeRepository.delete(employee);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
