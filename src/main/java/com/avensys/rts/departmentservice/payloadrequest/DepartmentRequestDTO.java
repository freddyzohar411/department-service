package com.avensys.rts.departmentservice.payloadrequest;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * author: Koh He Xiang This class is used to declare the request body for
 * Department
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDTO {

	@Length(max = 50)
	private String name;
}
