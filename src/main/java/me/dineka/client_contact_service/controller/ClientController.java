package me.dineka.client_contact_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import me.dineka.client_contact_service.dto.ClientRequestDTO;
import me.dineka.client_contact_service.dto.ClientResponseDTO;
import me.dineka.client_contact_service.model.Client;
import me.dineka.client_contact_service.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    @Operation(summary = "Получить инфо по клиенту по id", description = "Получение информации о клиенте по id")
    public ResponseEntity<Client> getClientInfoById(@PathVariable long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAll());
    }
}
