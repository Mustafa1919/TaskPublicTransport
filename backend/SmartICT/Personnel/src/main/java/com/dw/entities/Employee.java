package com.dw.entities;

import com.dw.enums.ROLE;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private ROLE role;
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Request> requests;

    public Employee(String userName, String password, String email, ROLE role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
