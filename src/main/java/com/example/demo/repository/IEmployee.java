package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

/**
 * @author JThakur
 *
 */

public interface IEmployee extends CrudRepository<Employee, Long> {

/*	Employee findUser(String userName);*/
	
}
