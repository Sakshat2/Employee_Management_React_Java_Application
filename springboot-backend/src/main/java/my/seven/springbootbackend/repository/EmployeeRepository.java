package my.seven.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.seven.springbootbackend.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//all the crud database  methods
}
