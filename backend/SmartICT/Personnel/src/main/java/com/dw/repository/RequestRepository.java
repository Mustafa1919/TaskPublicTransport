package com.dw.repository;

import com.dw.entities.Request;
import com.dw.enums.STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,String> {

    List<Request> findAllByOrderByDateAsc();
    List<Request> findByEntityNameOrderByDateAsc(String entityName);
    List<Request> findByEntityNameAndEntityIdOrderByDateAsc(String entityName, String entityId);
    List<Request> findByStatusOrderByDateAsc(STATUS status);


}
