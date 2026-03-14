package com.example.employee.service;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());
        existing.setDepartment(employee.getDepartment());

        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    @Override
    public List<Employee> getHighSalary(Double salary) {
        return repository.findBySalaryGreaterThan(salary);
    }

    @Override
    public long countEmployees() {
        return repository.count();
    }

    @Override
    public List<Employee> sortBySalary() {
        return repository.findAll(Sort.by("salary"));
    }

    @Override
    public Page<Employee> paginate(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public List<Employee> salaryAboveAverage() {
        return repository.findSalaryAboveAverage();
    }
}