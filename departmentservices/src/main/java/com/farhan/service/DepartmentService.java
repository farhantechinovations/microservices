package com.farhan.service;

import com.farhan.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveAllDepartment(DepartmentDto departmentDto);

    DepartmentDto findByDepartmentCode(String departmentCode);
}
