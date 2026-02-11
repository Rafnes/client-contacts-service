package me.dineka.client_contact_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class ClientRequestDTO {
    @NotNull @NotBlank(message = "Имя клиента не может быть пустым")
    private String name;

    @NotNull @NotBlank(message = "Фамилия клиента не может быть пустой")
    private String lastName;
}
