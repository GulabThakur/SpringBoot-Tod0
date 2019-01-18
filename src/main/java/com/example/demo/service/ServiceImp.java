package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployee;
import com.example.demo.validation.IValidation;

/**
 * @author JThakur
 *
 */
@Service
public class ServiceImp implements IempService {

	@Autowired
	IValidation validation;

	@Autowired
	IEmployee empDao;

	@Autowired
	BCryptPasswordEncoder passwordCript;

	@Override
	public void addemp(Employee emp) {
		validation.empEmail(emp.getEmpEmail());
		validation.empName(emp.getEmpName());
		validation.password(emp.getEmpPass());
		validation.equal(emp.getEmpPass(), emp.getEmpConf());
		boolean status1 = validation.valid();

		if (status1) {
			String empPass = emp.getEmpPass();
			String hashcode = passwordCript.encode(emp.getEmpPass());
			emp.setEmpPass(hashcode);
			boolean status = passwordCript.matches(empPass, hashcode);
			System.out.println("vliad :" + status);
			empDao.save(emp);
		}
	}

	@Override
	public void delete(Long empId) {
		empDao.delete(empId);
	}

	@Override
	public Employee getEmp(Long email) {
		Employee emp = empDao.findOne(email);
		return emp;
	}

	@Override
	public void update(Employee emp) {
		empDao.save(emp);
	}

	@Override
	public List<Employee> allEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findUser(String userName) {
		/*empDao.findUser(userName);*/
		return null;
	}

}
