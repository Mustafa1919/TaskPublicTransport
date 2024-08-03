package com.dw.dto;

import com.dw.entities.Employee;
import com.dw.enums.ROLE;

public record PersonnelResponse(
        String userName,
        String eMail,
        ROLE role
) {
    public static PersonnelResponse fromEmployee(Employee employee) {
        return new PersonnelResponse(
                employee.getUserName(),
                employee.getEmail(),
                employee.getRole()
        );
    }
}
