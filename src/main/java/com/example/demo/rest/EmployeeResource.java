package com.example.demo.rest;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResource {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public EmployeeResource(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/emp_dept")
    public ResponseEntity<?> saveEmpAndDept() {

        Department department = new Department();
        department.setDepartmentName("Gosho");

        Department savedDepartment = departmentRepository.save(department);

        Employee employee = new Employee();
        employee.setDepartment(savedDepartment);
        employee.setName("Gosho");
        employee.setSalary(100d);

        Employee employee2 = new Employee();
        employee2.setDepartment(savedDepartment);
        employee2.setName("Gosho2");
        employee2.setSalary(100d);


        employeeRepository.save(employee);
        employeeRepository.save(employee2);

        return ResponseEntity.ok().build();
    }
}
