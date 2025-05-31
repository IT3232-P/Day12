package lk.ac.vau.fas.ict.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@Column(name="dep_id")
	private String id;
	
	@Column(nullable=false)
	private String depName;
	
	private Date established;
	
	@JsonIgnore
	@OneToMany(mappedBy="department")
	private List<Employee> employees;

	public Department() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Date getEstablished() {
		return established;
	}

	public void setEstablished(Date established) {
		this.established = established;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
