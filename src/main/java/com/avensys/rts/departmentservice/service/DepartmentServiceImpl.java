package com.avensys.rts.departmentservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.avensys.rts.departmentservice.entity.DepartmentEntity;
import com.avensys.rts.departmentservice.payloadrequest.DepartmentRequestDTO;
import com.avensys.rts.departmentservice.payloadresponse.DepartmentResponseDTO;
import com.avensys.rts.departmentservice.repository.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author Koh He Xiang
 * This class is used to implement the methods in DepartmentService
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * This method is used to get all the departments
     * @return List<DepartmentResponseDTO>
     */
    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        log.info("Getting all departments: Service");
        return departmentRepository.findAll().stream().map(this::toDepartmentResponseDTO).toList();
    }

    /**
     * This method is used to get department by id
     * @param id
     * @return DepartmentResponseDTO
     */
    @Override
    public DepartmentResponseDTO getDepartmentById(Integer id) {
        log.info("Getting department by id: Service");
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Department with id " + id + " not found"));
        return toDepartmentResponseDTO(departmentEntity);
    }

    /**
     * This method is used to create a department
     * @param departmentRequest
     * @return DepartmentResponseDTO
     */
    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequest) {
        log.info("Creating department: Service");
        DepartmentEntity departmentSaved = departmentRepository.save(toDepartmentEntity(departmentRequest));
        return toDepartmentResponseDTO(departmentSaved);
    }

    /**
     * This method is used to update a department
     * @param id
     * @param departmentRequest
     * @return DepartmentResponseDTO
     */
    @Override
    public DepartmentResponseDTO updateDepartment(Integer id, DepartmentRequestDTO departmentRequest) {
        log.info("Updating department: Service");
        DepartmentEntity departmentFound = departmentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Department with id " + id + " not found"));
        departmentFound.setName(departmentRequest.getName());
        DepartmentEntity departmentSaved = departmentRepository.save(departmentFound);
        return toDepartmentResponseDTO(departmentSaved);
    }

    /**
     * This method is used to delete a department
     * @param id
     */
    @Override
    public void deleteDepartment(Integer id) {
        DepartmentEntity departmentFound = departmentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Department with id " + id + " not found"));
        departmentRepository.delete(departmentFound);
    }

    /**
     * This method is used to convert DepartmentEntity to DepartmentResponseDTO
     * @param departmentEntity
     * @return DepartmentResponseDTO
     */
    private DepartmentResponseDTO toDepartmentResponseDTO(DepartmentEntity departmentEntity) {
        DepartmentResponseDTO departmentResponseDTO = new DepartmentResponseDTO();
        departmentResponseDTO.setId(departmentEntity.getId());
        departmentResponseDTO.setName(departmentEntity.getName());
        return departmentResponseDTO;
    }

    /**
     * This method is used to convert DepartmentRequestDTO to DepartmentEntity
     * @param departmentRequestDTO
     * @return DepartmentEntity
     */
    private DepartmentEntity toDepartmentEntity(DepartmentRequestDTO departmentRequestDTO) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName(departmentRequestDTO.getName());
        return departmentEntity;
    }
}
