package com.farhan.service;

import com.farhan.dto.ApiResponse;
import com.farhan.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveAllDepartment(EmployeeDto employeeDto);

    ApiResponse findEmployeeById(Long id);
}
