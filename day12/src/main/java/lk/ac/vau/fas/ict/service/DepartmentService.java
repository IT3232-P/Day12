package lk.ac.vau.fas.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.Department;
import lk.ac.vau.fas.ict.repo.DepartmentRepo;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	
	public List<Department> getDeps(){
		return repo.findAll();
	}
	
	public Department getDepwithId(String id ) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.findById(id).get();
	}
	
	public String addDep(Department department) {
		if(repo.findById(department.getId()).isEmpty()) {
			repo.save(department);
			return "New Department Added";			
		}
		throw new DuplicateKeyException("Department already Exists");
			
	}
	
	public String deleteDep(String id) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		repo.deleteById(id);
		return "Department removed";
		
	}
	
	public String updateDep(String id, Department department) {
		if(repo.findById(id).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		repo.save(department);
		return "Department updated";
	}
	
	public List<String> getDepartmentNames() {
		if(repo.getDeptNames().isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.getDeptNames();
	}
	
	public List<Department> searchName(String name) {
		if(repo.getDeptByName(name).isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.getDeptByName(name);
	}
	
	public List<String> empCount() {
		if(repo.getEmpCountbyDep().isEmpty()) {
			throw new EntityNotFoundException("Department Not Found");
		}
		return repo.getEmpCountbyDep();
	}
}