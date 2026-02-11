package me.dineka.client_contact_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import me.dineka.client_contact_service.dto.ClientRequestDTO;
import me.dineka.client_contact_service.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@Tag(name = "Клиенты", description = "Управление данными клиентов")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    @Operation(summary = "Добавить клиента", description = "Добавление нового клиента")
    public ResponseEntity<Void> addCurrency(@RequestBody @Valid ClientRequestDTO dto) {
        clientService.addClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
