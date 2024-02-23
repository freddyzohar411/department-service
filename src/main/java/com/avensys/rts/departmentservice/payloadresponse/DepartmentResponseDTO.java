package com.avensys.rts.departmentservice.payloadresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: Koh He Xiang This is the DTO class for the Department response
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDTO {
	private Integer id;
	private String name;
}
