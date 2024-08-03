package com.dw.service;


import com.dw.dto.PersonnelResponse;
import com.dw.dto.RequestLogResponse;
import com.dw.entities.Employee;
import com.dw.enums.ROLE;
import com.dw.repository.PersonnelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonnelServiceTest {

    private PersonnelService personnelService;

    private PersonnelRepository personnelRepository;
    private RequestService requestService;

    @BeforeEach
    public void setUp(){
        personnelRepository = Mockito.mock(PersonnelRepository.class);
        requestService = Mockito.mock(RequestService.class);
        personnelService = new PersonnelService(personnelRepository, requestService);
    }

    // Adim 1: Test ismini yazilmasi
    @Test
    public void shouldReturnPersonnelResponseWithUserNameAndEmailAndRole_whenExistingLoginName(){
        // Adim 2: Test verilerinin hazirlanmasi
        Employee employee = new Employee("3123","Mustafa","4545","test@test", ROLE.ADMIN);
        PersonnelResponse expectedResponse = new PersonnelResponse("Mustafa", "test@test", ROLE.ADMIN);

        // Adim 3: Bagimli servicelerin davranislarinin belirlenmesi
        Mockito.when(personnelRepository.findByUserNameOrEmail("Mustafa","Mustafa"))
                .thenReturn(Optional.of(employee));

        // Adim 4: Test edilecek metodun calistirilmasi
        PersonnelResponse response = personnelService.getPersonnel("Mustafa");

        // Adim 5: Test sonuclarinin karsilastirilmasi
        assertEquals(expectedResponse, response);

        // Adim 6: Bagimli servislerin calisitirilmasinin kontrol edilmesi
        Mockito.verify(personnelRepository).findByUserNameOrEmail("Mustafa","Mustafa");

    }

//    @Test
//    public void shouldReturnPersonnelResponseWithUserNameAndEmailAndRole_whenExistingEmail(){
//        Employee employee = new Employee("3123","Mustafa","4545","test@test", ROLE.ADMIN, null);
//    }
//
//    @Test
//    public void shouldThrowPersonnelExceptionWithUSERNOTFOUND_whenNotExistLoginName(){
//        Employee employee = new Employee("3123","Mustafa","4545","test@test", ROLE.ADMIN, null);
//    }
//
//    @Test
//    public void shouldThrowPersonnelExceptionWithUSERNOTFOUND_whenNotExistEmail(){
//        Employee employee = new Employee("3123","Mustafa","4545","test@test", ROLE.ADMIN, null);
//    }

    @AfterEach
    public void tearDown(){
        personnelRepository = null;
        personnelService = null;
        requestService = null;
    }

}
