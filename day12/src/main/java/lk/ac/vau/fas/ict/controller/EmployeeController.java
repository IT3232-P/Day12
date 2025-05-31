package lk.ac.vau.fas.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Employee;
import lk.ac.vau.fas.ict.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

		@Autowired
		public EmployeeService service;
		
		@GetMapping("/")
		public ResponseEntity<List<Employee>> getEmp(){
			return new ResponseEntity<List<Employee>>(service.getEmp(),HttpStatus.OK);
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<Employee> getEmptwithId(@PathVariable String id){
			if(service.getEmpwithId(id)==null) {
				return new ResponseEntity<Employee>(service.getEmpwithId(id),HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Employee>(service.getEmpwithId(id),HttpStatus.OK);
		}
		
		
		@PostMapping("/")
		public String addEmp(@RequestBody Employee employee){
				return new String(service.addEmp(employee));
		}
		
		@DeleteMapping("/{id}")
		public String deleteEmp(@PathVariable("id") String id){
			if(service.getEmpwithId(id)==null) {
				return "Couldn't find Employee";
			}
			return new String(service.deleteEmp(id));
		}
		
		@PutMapping("/{id}")
		public String updateEmp(@PathVariable("id") String id,@RequestBody Employee employee){
			if(service.updateEmp(id,employee)==null) {
				return "Couldn't find Employee";
			}
			return new String(service.updateEmp(id,employee));
		}
		
//		@GetMapping("/salaryRange")
//		public ResponseEntity<List<Employee>> searchBySalary(){
//			if(service.searchBySalary()==null) {
//				return new ResponseEntity<List<Employee>>(service.searchBySalary(),HttpStatus.NOT_FOUND);
//			}
//			return new ResponseEntity<List<Employee>>(service.searchBySalary(),HttpStatus.OK);
//		}
		
		@GetMapping("/salaryRange/{min}/{max}")
		public ResponseEntity<List<Employee>> searchBySalary(@PathVariable("min") int min,@PathVariable("max") int max){
			if(service.searchBySalary(min,max)==null) {
				return new ResponseEntity<List<Employee>>(service.searchBySalary(min,max),HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Employee>>(service.searchBySalary(min,max),HttpStatus.OK);
		}
		
		@GetMapping("/byDep/{depId}")
		public ResponseEntity<List<Employee>> searchEmpsByDep(@PathVariable("depId") String depId){
			if(service.searchEmpsByDep(depId)==null) {
				return new ResponseEntity<List<Employee>>(service.searchEmpsByDep(depId),HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Employee>>(service.searchEmpsByDep(depId),HttpStatus.OK);
		}
		
		@GetMapping("/youngest")
		public ResponseEntity<List<Employee>> findYoungest(){
			if(service.findYoungest()==null) {
				return new ResponseEntity<List<Employee>>(service.findYoungest(),HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Employee>>(service.findYoungest(),HttpStatus.OK);
		}
}
