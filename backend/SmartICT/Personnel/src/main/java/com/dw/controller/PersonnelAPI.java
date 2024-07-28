package com.dw.controller;

import com.dw.dto.PersonnelRequest;
import com.dw.dto.PersonnelResponse;
import com.dw.dto.PersonnelUpdateRequest;
import com.dw.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/personnel")
@RequiredArgsConstructor
public class PersonnelAPI {

    private final PersonnelService personnelService;

    @GetMapping()
    public ResponseEntity<PersonnelResponse> getPersonnel(@RequestParam String loginName) {
        return ResponseEntity.ok(this.personnelService.getPersonnel(loginName));
    }


    @GetMapping("/employees")
    public ResponseEntity<List<PersonnelResponse>> getEmployees() {
        return ResponseEntity.ok(this.personnelService.getEmployees());
    }

    @PostMapping
    public ResponseEntity<PersonnelResponse> addPersonnel(@RequestBody PersonnelRequest personnelRequest) {
        return ResponseEntity.ok(this.personnelService.createPersonnel(personnelRequest));
    }

    @PutMapping
    public ResponseEntity<PersonnelResponse> updatePersonnel(@RequestBody PersonnelUpdateRequest personnelRequest) {
        return ResponseEntity.ok(this.personnelService.updatePersonnel(personnelRequest));
    }

    @DeleteMapping
    public ResponseEntity<?> deletePersonnel(@RequestParam String loginName) {
        this.personnelService.delete(loginName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
