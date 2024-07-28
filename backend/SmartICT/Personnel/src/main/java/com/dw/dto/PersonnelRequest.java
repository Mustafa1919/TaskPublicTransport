package com.dw.dto;

import com.dw.entities.Employee;
import com.dw.enums.ROLE;

public record PersonnelRequest(
        String userName,
        String eMail,
        String password,
        ROLE role
) {

    public Employee toEmployee() {
        return new Employee(
                this.userName,
                this.password,
                this.eMail,
                this.role
        );
    }
}
