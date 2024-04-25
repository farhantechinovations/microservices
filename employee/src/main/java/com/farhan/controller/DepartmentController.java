package com.farhan.controller;


import com.farhan.dto.ApiResponse;
import com.farhan.dto.EmployeeDto;
import com.farhan.entity.EmployeeEntity;
import com.farhan.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employee")
public class DepartmentController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveAllemployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto SaveEmployeeBy = employeeService.saveAllDepartment(employeeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> findbyId(@PathVariable Long id){
        ApiResponse findById = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(findById,HttpStatus.OK);
    }
}
