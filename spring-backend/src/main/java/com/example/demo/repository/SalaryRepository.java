package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long>{

}
