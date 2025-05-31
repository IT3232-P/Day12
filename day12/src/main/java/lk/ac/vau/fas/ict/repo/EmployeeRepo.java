package lk.ac.vau.fas.ict.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lk.ac.vau.fas.ict.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String>{
	//find the employees with salary range 70000 to 90000
	@Query("SELECT e FROM Employee e WHERE e.salary between %?1% AND %?2%")
	public List<Employee> searchEmpbySalRange(int a, int b);
	
	//employee who work in a department
	@Query("SELECT e FROM Employee e WHERE e.department.id = %?1%")
	public List<Employee> searchByDep(String depId);

	//find the youngest employee
	@Query("SELECT e FROM Employee e WHERE e.age = (SELECT MIN(e.age) FROM Employee e)")
	public List<Employee> youngestEmp();
}