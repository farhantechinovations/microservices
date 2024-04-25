package com.farhan.controller;


import com.farhan.dto.DepartmentDto;
import com.farhan.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveAllDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto saveAll = departmentService.saveAllDepartment(departmentDto);
        return new ResponseEntity<>(saveAll, HttpStatus.CREATED);
    }
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> findbyCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDto findBycode = departmentService.findByDepartmentCode(departmentCode);
        return new ResponseEntity<>(findBycode,HttpStatus.OK);
    }
}
