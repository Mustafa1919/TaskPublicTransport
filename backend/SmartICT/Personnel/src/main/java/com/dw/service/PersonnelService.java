package com.dw.service;

import com.dw.dto.PersonnelRequest;
import com.dw.dto.PersonnelResponse;
import com.dw.dto.PersonnelUpdateRequest;
import com.dw.entities.Employee;
import com.dw.exception.ErrorType;
import com.dw.exception.PersonnelException;
import com.dw.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonnelService {

    private final PersonnelRepository personnelRepository;

    public PersonnelResponse getPersonnel(String loginName) {
        Employee employee = this.personnelRepository
                .findByUserNameOrEMail(loginName)
                .orElseThrow( () -> new PersonnelException(ErrorType.USER_NOT_FOUND));
        return PersonnelResponse.fromEmployee(employee);
    }

    public List<PersonnelResponse> getEmployees() {
        return this.personnelRepository
                .findAll()
                .stream()
                .map(PersonnelResponse::fromEmployee)
                .collect(Collectors.toList());
    }

    public PersonnelResponse createPersonnel(PersonnelRequest personnelRequest) {
        return PersonnelResponse
                .fromEmployee(this.personnelRepository
                        .save(personnelRequest.toEmployee()));
    }

    public PersonnelResponse updatePersonnel(PersonnelUpdateRequest personnelUpdateRequest) {
        Optional<Employee> employee = this.personnelRepository.findByUserNameOrEMail(personnelUpdateRequest.userName());
        if (employee.isEmpty()){
            employee = this.personnelRepository.findByUserNameOrEMail(personnelUpdateRequest.eMail());
            if(employee.isEmpty()){
                throw new PersonnelException(ErrorType.USER_NOT_UPDATE);
            }else{
                return PersonnelResponse.fromEmployee(updatePersonnelFromDb(employee.get(), personnelUpdateRequest));
            }
        }else{
            return PersonnelResponse.fromEmployee(updatePersonnelFromDb(employee.get(), personnelUpdateRequest));
        }
    }

    public void delete(String loginName) {
        this.personnelRepository.deleteByUserNameOrEMail(loginName);
    }

    private Employee updatePersonnelFromDb(Employee dbEmployee, PersonnelUpdateRequest personnel) {
        dbEmployee.setUserName(personnel.userName());
        dbEmployee.setEMail(personnel.eMail());
        dbEmployee.setRole(personnel.role());
        return this.personnelRepository.save(dbEmployee);
    }

}
