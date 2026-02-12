package me.dineka.client_contact_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequestDTO {
    @NotBlank(message = "Телефон не может быть пустым")
    private String phone;

    private String email;
}
