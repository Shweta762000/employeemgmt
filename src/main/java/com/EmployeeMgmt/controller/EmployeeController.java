package com.EmployeeMgmt.controller;

import com.EmployeeMgmt.entity.Employee;
import com.EmployeeMgmt.helper.ApiResponce;
import com.EmployeeMgmt.service.EmployeeService;
import com.EmployeeMgmt.service.serviceImpl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/")
    public ResponseEntity<Employee> createEmp(@Valid @RequestBody Employee emp){
        Employee emp1 = employeeService.createEmp(emp);
        return new ResponseEntity<>(emp1, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmp(@Valid @RequestBody Employee emp, @PathVariable Long id){
        Employee emp1 = employeeService.updateEmp(emp,id);
        return new ResponseEntity<>(emp1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponce> deleteEmp(@PathVariable Long id){
        employeeService.deleteEmp(id);
        ApiResponce responce = ApiResponce.builder().message("user deleted sucessfully....").success(true).status(HttpStatus.OK).build();
return new ResponseEntity<>(responce,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getallEmp(){
        List<Employee> employees = employeeService.getallEmp();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/getbyid")
   public ResponseEntity<Employee> getEmpById(@RequestParam Long id){
        Employee empById = employeeService.getEmpById(id);
        return new ResponseEntity<>(empById,HttpStatus.OK);
    }
}
