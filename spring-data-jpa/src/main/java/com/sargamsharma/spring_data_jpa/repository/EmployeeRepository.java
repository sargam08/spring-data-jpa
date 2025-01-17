package com.sargamsharma.spring_data_jpa.repository;

import com.sargamsharma.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marking the repository explicitly
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
