package me.dineka.client_contact_service.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dineka.client_contact_service.dto.ContactRequestDTO;
import me.dineka.client_contact_service.model.Client;
import me.dineka.client_contact_service.service.ClientService;
import me.dineka.client_contact_service.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
@Tag(name = "Контакты", description = "Управление контактами клиентов")
public class ContactController {
    private final ClientService clientService;
    private final ContactService contactService;

    public ContactController(ClientService clientService, ContactService contactService) {
        this.clientService = clientService;
        this.contactService = contactService;
    }

    public ResponseEntity<Void> addContact(@RequestParam long clientId, ContactRequestDTO dto) {
        Client client = clientService.findById(clientId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
