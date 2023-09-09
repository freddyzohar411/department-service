package com.avensys.rts.departmentservice.payloadrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * author: Koh He Xiang
 * This class is used to declare the request body for Department
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestDTO {

    @Length(max = 50)
    private String name;
}
