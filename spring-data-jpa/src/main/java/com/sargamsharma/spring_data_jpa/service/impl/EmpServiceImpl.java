package com.sargamsharma.spring_data_jpa.service.impl;

import com.sargamsharma.spring_data_jpa.dto.EmployeeDto;
import com.sargamsharma.spring_data_jpa.entity.Employee;
import com.sargamsharma.spring_data_jpa.exception.ResourceNotFoundException;
import com.sargamsharma.spring_data_jpa.mapper.EmployeeMapper;
import com.sargamsharma.spring_data_jpa.repository.EmployeeRepository;
import com.sargamsharma.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired // Constructor-based dependency injection
    public EmpServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Map DTO to Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // Save entity to database
        Employee savedEmployee = employeeRepository.save(employee);

        // Map Entity back to DTO and return
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
     Employee employee =   employeeRepository.findById(employeeId)
               .orElseThrow(() ->
                       new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));




        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employess =  employeeRepository.findAll();
        return employess.stream().map((employee) ->
                EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);




    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);

    }
}
