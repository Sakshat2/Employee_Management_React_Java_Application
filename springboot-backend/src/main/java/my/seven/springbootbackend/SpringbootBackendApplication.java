package my.seven.springbootbackend;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import my.seven.springbootbackend.model.Employee;
import my.seven.springbootbackend.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);}
	
	
		@Autowired
		private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Employee employee=new Employee();
//		employee.setFirstName("sakshat");
//		employee.setLastName("rapkar");
//		employee.setEmailId("sakshatrap@gmail.com");
//		employeeRepository.save(employee);
//		
//		Employee employee1=new Employee();
//		employee.setFirstName("suriya");
//		employee.setLastName("rapkar");
//		employee.setEmailId("greatttrap@gmail.com");
//		employeeRepository.save(employee1);
		
	}

}
