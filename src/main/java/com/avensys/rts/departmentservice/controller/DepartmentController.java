package com.avensys.rts.departmentservice.controller;

import com.avensys.rts.departmentservice.constant.MessageConstants;
import com.avensys.rts.departmentservice.payloadrequest.DepartmentRequestDTO;
import com.avensys.rts.departmentservice.payloadresponse.DepartmentResponseDTO;
import com.avensys.rts.departmentservice.service.DepartmentService;
import com.avensys.rts.departmentservice.util.ResponseUtil;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @author Koh He Xiang
 * This class is the controller class for department service implementation
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/departments")
public class DepartmentController {

    private final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentService departmentService;
    private final MessageSource messageSource;

    public DepartmentController(DepartmentService departmentService, MessageSource messageSource) {
        this.departmentService = departmentService;
        this.messageSource = messageSource;
    }

    /**
     * This method is used to get all the departments
     * @return ResponseEntity<List<DepartmentResponseDTO>>
     */
    @GetMapping("")
    public ResponseEntity<?> getAllDepartments() {
        log.info("Getting all departments: Controller");
        List<DepartmentResponseDTO> departmentResponseDTOList = departmentService.getAllDepartments();
        return ResponseUtil.generateSuccessResponse(departmentResponseDTOList, HttpStatus.OK, messageSource.getMessage(MessageConstants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
    }

    /**
     * This method is used to get department by id
     * @param id
     * @return ResponseEntity<DepartmentResponseDTO>
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Integer id) {
        log.info("Getting department by id: Controller");
        DepartmentResponseDTO departmentResponseDTO = departmentService.getDepartmentById(id);
        return ResponseUtil.generateSuccessResponse(departmentResponseDTO, HttpStatus.OK, messageSource.getMessage(MessageConstants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
    }

    /**
     * This method is used to create a department
     * @param departmentRequestDTO
     * @return ResponseEntity<DepartmentResponseDTO>
     */
    @PostMapping("")
    public ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        log.info("Creating department: Controller");
        DepartmentResponseDTO departmentResponseDTO = departmentService.createDepartment(departmentRequestDTO);
        return ResponseUtil.generateSuccessResponse(departmentResponseDTO, HttpStatus.CREATED, messageSource.getMessage(MessageConstants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
    }

    /**
     * This method is used to update a department
     * @param id
     * @param departmentRequestDTO
     * @return ResponseEntity<DepartmentResponseDTO>
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        log.info("Updating department: Controller");
        DepartmentResponseDTO departmentResponseDTO = departmentService.updateDepartment(id, departmentRequestDTO);
        return ResponseUtil.generateSuccessResponse(departmentResponseDTO, HttpStatus.OK, messageSource.getMessage(MessageConstants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
    }

    /**
     * This method is used to delete a department
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) {
        log.info("Deleting department: Controller");
        departmentService.deleteDepartment(id);
        return ResponseUtil.generateSuccessResponse(null, HttpStatus.OK, messageSource.getMessage(MessageConstants.MESSAGE_SUCCESS, null, LocaleContextHolder.getLocale()));
    }
}
