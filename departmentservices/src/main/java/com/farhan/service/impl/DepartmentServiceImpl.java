package com.farhan.service.impl;


import com.farhan.dto.DepartmentDto;
import com.farhan.entity.DepartmentEntity;
import com.farhan.repository.DepartmentRepository;
import com.farhan.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveAllDepartment(DepartmentDto departmentDto) {

        DepartmentEntity saveinEntity = new DepartmentEntity(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        DepartmentEntity saveDepartment = departmentRepository.save(saveinEntity);

        DepartmentDto dto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveinEntity.getDepartmentCode()
        );

        return dto;
    }

    @Override
    public DepartmentDto findByDepartmentCode(String departmentCode) {

        DepartmentEntity findbyid = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = new DepartmentDto(
                findbyid.getId(),
                findbyid.getDepartmentName(),
                findbyid.getDepartmentDescription(),
                findbyid.getDepartmentCode()
        );
        return departmentDto;
    }


}
