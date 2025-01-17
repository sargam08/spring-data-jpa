package com.sargamsharma.spring_data_jpa.service;

import com.sargamsharma.spring_data_jpa.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);
}
