package com.dw.dto;

import com.dw.enums.ROLE;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record PersonnelUpdateRequest(
        @NotBlank String userName,
        @NotBlank String eMail,
        @NotEmpty ROLE role
) {

}
