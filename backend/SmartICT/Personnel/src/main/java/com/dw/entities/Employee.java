package com.dw.entities;

import com.dw.enums.ROLE;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String employeeId;

    @Column(unique = true)
    private String userName;

    private String password;
    @Email
    @Column(unique = true)
    private String eMail;
    @Enumerated(EnumType.ORDINAL)
    private ROLE role;

    public Employee(String userName, String password, String eMail, ROLE role) {
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
        this.role = role;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
