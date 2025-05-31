package lk.ac.vau.fas.ict.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.vau.fas.ict.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String>{
	
	//JPQL
	@Query("Select depName from Department")
	public List<String> getDeptNames();
	
	@Query("SELECT d FROM Department d WHERE d.depName LIKE %?1%")
	public List<Department> getDeptByName(String name);
	
	//display departments along with the number of employees working there
	/*
	 * dept_name:HR
	 * no_emp:5
	 * 
	 * */
	
	@Query("SELECT count(*) from Department d"
			+ "join d.employees "
			+ "where d.id = ?1")
	public int numberOfEmp(int did);	
}