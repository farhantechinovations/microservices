package com.farhan.service;

import com.farhan.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {


    @GetMapping("api/department/{department-code}")
    DepartmentDto findbyCode(@PathVariable("department-code") String departmentCode);
}
