package com.springboot.Assignments.weekTwoAssignment.repositories;

import com.springboot.Assignments.weekTwoAssignment.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
