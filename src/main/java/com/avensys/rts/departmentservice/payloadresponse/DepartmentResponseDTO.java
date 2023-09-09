package com.avensys.rts.departmentservice.payloadresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: Koh He Xiang
 * This is the DTO class for the Department response
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDTO {
    private Integer id;
    private String name;
}
