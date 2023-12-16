package com.EmployeeMgmt.service.serviceImpl;

import com.EmployeeMgmt.Exception.MyException;
import com.EmployeeMgmt.entity.Employee;

import com.EmployeeMgmt.repository.EmployeeRepository;
import com.EmployeeMgmt.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmp(Employee emp) {
       return employeeRepository.save(emp);
    }

    @Override
    public Employee updateEmp(Employee updatedEmp, Long id) {
//        try{
//        if(employeeRepository.existsById(id)){
//            emp.setId(id);
//            return employeeRepository.save(emp);
//        }}catch (Exception e){
//            throw new MyException("Id not Found by MyException!!");
//        }

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new MyException("User not found with given Id!!"));
        existingEmployee.setName(updatedEmp.getName());
        existingEmployee.setEmail(updatedEmp.getEmail());
        existingEmployee.setDesignation(updatedEmp.getDesignation());
        existingEmployee.setJoinig_date(updatedEmp.getJoinig_date());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmp(Long id)  {

       // employeeRepository.deleteById(id);
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new MyException("user not found with given Id"));
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> getallEmp() {
     List<Employee> allemp=  employeeRepository.findAll();
     return allemp;
    }

    @Override
    public Employee getEmpById(Long id) {
       return  employeeRepository.findById(id).orElseThrow(()->new MyException("user not found with given Id"));


         }
}
