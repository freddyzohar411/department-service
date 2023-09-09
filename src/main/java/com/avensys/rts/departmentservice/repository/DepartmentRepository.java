package com.avensys.rts.departmentservice.repository;

import com.avensys.rts.departmentservice.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Koh He Xiang
 * This is the repository class for the Industry table in the database
 */
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
