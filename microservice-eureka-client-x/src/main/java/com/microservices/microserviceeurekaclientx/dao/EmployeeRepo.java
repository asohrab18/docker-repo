package com.microservices.microserviceeurekaclientx.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.microserviceeurekaclientx.beans.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
