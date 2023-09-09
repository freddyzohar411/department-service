package com.avensys.rts.departmentservice.service;

import com.avensys.rts.departmentservice.payloadrequest.DepartmentRequestDTO;
import com.avensys.rts.departmentservice.payloadresponse.DepartmentResponseDTO;

import java.util.List;

/**
 * @author Koh He Xiang
 * This interface is used to declare methods for DepartmentService
 */
public interface DepartmentService {

    /**
     * This method is used to get all the departments
     * @return
     */
    public List<DepartmentResponseDTO> getAllDepartments();

    /**
     * This method is used to get department by id
     * @param id
     * @return
     */
    public DepartmentResponseDTO getDepartmentById(Integer id);

    /**
     * This method is used to create a department
     * @param departmentRequest
     * @return
     */
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequest);

    /**
     * This method is used to update a department
     * @param id
     * @param departmentRequest
     * @return
     */
    public DepartmentResponseDTO updateDepartment(Integer id, DepartmentRequestDTO departmentRequest);

    /**
     * This method is used to delete a department
     * @param id
     */
    public void deleteDepartment(Integer id);
}
