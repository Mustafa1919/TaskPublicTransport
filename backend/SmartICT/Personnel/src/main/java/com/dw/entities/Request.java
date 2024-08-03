package com.dw.entities;

import com.dw.enums.ACTION_TYPE;
import com.dw.enums.STATUS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String requestId;

    @Enumerated(EnumType.STRING)
    private ACTION_TYPE actionType;
    private String entityName;
    private String entityId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Enumerated(EnumType.STRING)
    private STATUS status;
    private String message;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Employee employee;

    public Request(ACTION_TYPE actionType, String entityName, String entityId, STATUS status, String message) {
        this.actionType = actionType;
        this.entityName = entityName;
        this.entityId = entityId;
        this.date = new Date();
        this.status = status;
        this.message = message;
    }
}
