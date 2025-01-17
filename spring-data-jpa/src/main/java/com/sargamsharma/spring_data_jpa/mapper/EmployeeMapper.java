package com.sargamsharma.spring_data_jpa.mapper;

import com.sargamsharma.spring_data_jpa.dto.EmployeeDto;
import com.sargamsharma.spring_data_jpa.entity.Employee;

public class EmployeeMapper {

    // Map Entity to DTO
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // Map DTO to Entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
