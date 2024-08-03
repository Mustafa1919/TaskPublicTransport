package com.dw.service;

import com.dw.dto.PersonnelRequest;
import com.dw.dto.PersonnelResponse;
import com.dw.dto.PersonnelUpdateRequest;
import com.dw.dto.RequestLog;
import com.dw.entities.Employee;
import com.dw.enums.ACTION_TYPE;
import com.dw.enums.STATUS;
import com.dw.exception.ErrorType;
import com.dw.exception.PersonnelException;
import com.dw.repository.PersonnelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final RequestService requestService;

    public PersonnelResponse getPersonnel(String loginName) {
        Employee employee = this.personnelRepository
                .findByUserNameOrEmail(loginName, loginName)
                .orElseThrow( () -> new PersonnelException(ErrorType.USER_NOT_FOUND));

        requestService.createRequestLog(
                new RequestLog(ACTION_TYPE.GET,
                        "Personnel",
                        loginName,
                        STATUS.SUCCESS,
                        "getPersonnel")
        );
        return PersonnelResponse.fromEmployee(employee);
    }

    public List<PersonnelResponse> getEmployees() {
        requestService.createRequestLog(
                new RequestLog(ACTION_TYPE.GET,
                        "Personnel",
                        "",
                        STATUS.SUCCESS,
                        "getEmployees")
        );
        return this.personnelRepository
                .findAll()
                .stream()
                .map(PersonnelResponse::fromEmployee)
                .collect(Collectors.toList());
    }

    public PersonnelResponse createPersonnel(PersonnelRequest personnelRequest) {
        requestService.createRequestLog(
                new RequestLog(ACTION_TYPE.CREATE,
                        "Personnel",
                        personnelRequest.eMail(),
                        STATUS.SUCCESS,
                        "createPersonnel")
        );
        return PersonnelResponse
                .fromEmployee(this.personnelRepository
                        .save(personnelRequest.toEmployee()));
    }

    public PersonnelResponse updatePersonnel(PersonnelUpdateRequest personnelUpdateRequest) {
        Optional<Employee> employee = this.personnelRepository.findByUserNameOrEmail(personnelUpdateRequest.userName(), personnelUpdateRequest.eMail());
        if (employee.isEmpty()){
            throw new PersonnelException(ErrorType.USER_NOT_UPDATE);
        }else{
            requestService.createRequestLog(
                    new RequestLog(ACTION_TYPE.UPDATE,
                            "Personnel",
                            personnelUpdateRequest.eMail(),
                            STATUS.SUCCESS,
                            "updatePersonnel")
            );
            return PersonnelResponse.fromEmployee(updatePersonnelFromDb(employee.get(), personnelUpdateRequest));
        }
    }

    @Transactional
    public void delete(String loginName) {
        requestService.createRequestLog(
                new RequestLog(ACTION_TYPE.DELETE,
                        "Personnel",
                        loginName,
                        STATUS.CONTINUE,
                        "delete")
        );
        this.personnelRepository.deleteByUserNameOrEmail(loginName, loginName);
    }

    private Employee updatePersonnelFromDb(Employee dbEmployee, PersonnelUpdateRequest personnel) {
        dbEmployee.setUserName(personnel.userName());
        dbEmployee.setEmail(personnel.eMail());
        dbEmployee.setRole(personnel.role());
        return this.personnelRepository.save(dbEmployee);
    }

}
