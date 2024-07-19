package com.springboot.Assignments.weekTwoAssignment.controllers;

import com.springboot.Assignments.weekTwoAssignment.Exceptions.ResourceNotFoundException;
import com.springboot.Assignments.weekTwoAssignment.dto.DepartmentDTO;
import com.springboot.Assignments.weekTwoAssignment.services.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId){
       Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(departmentId);
       return departmentDTO
               .map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
               .orElseThrow(()-> new ResourceNotFoundException("Department not found"));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
       return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.createNewDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable(name = "departmentId") Long id, @RequestBody DepartmentDTO departmentDTO){
       DepartmentDTO departmentDTO1 =  departmentService.updateDepartmentById(id, departmentDTO);
       return ResponseEntity.ok(departmentDTO1);
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.deleteDepartmentById(departmentId));
    }

    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> partialUpdateDepartmentById(@RequestBody Map<String, Object> objectMap, @PathVariable Long departmentId){
        DepartmentDTO departmentDTO = departmentService.partialUpdateDepartmentById(departmentId, objectMap);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

   /* @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> partialUpdateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId){
        DepartmentDTO departmentDTO1 = departmentService.partialUpdateDepartmentById(departmentId, departmentDTO);
        if (departmentDTO == null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(departmentDTO1, HttpStatus.OK);
    }*/


}
