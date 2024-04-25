package com.farhan.service.impl;

import com.farhan.dto.ApiResponse;
import com.farhan.dto.DepartmentDto;
import com.farhan.dto.EmployeeDto;
import com.farhan.entity.EmployeeEntity;
import com.farhan.repository.EmployeeRepository;
import com.farhan.service.APIClient;
import com.farhan.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private APIClient apiClient;
   // private RestTemplate restTemplate;
   // private WebClient webClient;



    @Override
    public EmployeeDto saveAllDepartment(EmployeeDto employeeDto) {

        EmployeeEntity saveAllTheEntity = new EmployeeEntity(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        EmployeeEntity saveinEntity = employeeRepository.save(saveAllTheEntity);

        EmployeeDto saveInDto = new EmployeeDto(
                saveinEntity.getId(),
                saveinEntity.getFirstName(),
                saveinEntity.getLastName(),
                saveinEntity.getEmail(),
                saveinEntity.getDepartmentCode()
        );

        return saveInDto;
    }

    @Override
    public ApiResponse findEmployeeById(Long id) {
        EmployeeEntity findByid = employeeRepository.findById(id).get();

//        ResponseEntity<DepartmentDto> response = restTemplate.getForEntity("http://localhost:8080/api/department/"
//                + findByid.getDepartmentCode() , DepartmentDto.class);
//        DepartmentDto departmentDto = response.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/department/"
//                        + findByid.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.findbyCode(findByid.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                findByid.getId(),
                findByid.getFirstName(),
                findByid.getLastName(),
                findByid.getEmail(),
                findByid.getDepartmentCode()
        );

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setEmployeeDto(employeeDto);
        apiResponse.setDepartmentDto(departmentDto);

        return apiResponse;
    }
}
