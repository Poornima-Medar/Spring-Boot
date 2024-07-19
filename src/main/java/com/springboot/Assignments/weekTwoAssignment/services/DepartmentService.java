package com.springboot.Assignments.weekTwoAssignment.services;

import com.springboot.Assignments.weekTwoAssignment.Exceptions.ResourceNotFoundException;
import com.springboot.Assignments.weekTwoAssignment.dto.DepartmentDTO;
import com.springboot.Assignments.weekTwoAssignment.entities.DepartmentEntity;
import com.springboot.Assignments.weekTwoAssignment.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDTO> getDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId).map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity saveDepartmentEntity =  departmentRepository.save(departmentEntity);
        return modelMapper.map(saveDepartmentEntity, DepartmentDTO.class);
    }


    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }


    public DepartmentDTO updateDepartmentById(Long id, DepartmentDTO departmentDTO) {
        existDepartmentById(id);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity saveDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(saveDepartmentEntity, DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long departmentId) {
        existDepartmentById(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentDTO partialUpdateDepartmentById(Long departmentId, Map<String,Object> objectMap) {
        existDepartmentById(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        objectMap.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public void existDepartmentById(Long id){
        boolean exist = departmentRepository.existsById(id);
        if (!exist) throw new ResourceNotFoundException("Department not found with id: "+ id);
    }

}
