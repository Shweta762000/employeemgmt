package com.EmployeeMgmt.service;

import com.EmployeeMgmt.entity.Employee;

import java.util.List;

public interface EmployeeService {
     Employee createEmp(Employee emp);
     Employee updateEmp(Employee emp,Long id);

     void deleteEmp(Long id);

     List<Employee> getallEmp();
     Employee getEmpById(Long id);

}
