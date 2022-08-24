package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	/*
	 * @Autowired public static final EntityManager emEntityManager = null;
	 * 
	 * @SuppressWarnings("unchecked") public static List<Employee>
	 * getPaidUsersEntity() { return
	 * emEntityManager.createNamedStoredProcedureQuery("getPaidUsersEntity").
	 * getResultList(); }
	 */
	
	//@Procedure(name  = "getPaidUsersEntity")
	@Query(value = "CALL getPaidUsers();", nativeQuery = true)
	List<Employee> getPaidEmployees();
}
