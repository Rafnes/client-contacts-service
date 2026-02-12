package me.dineka.client_contact_service.service;

import lombok.extern.slf4j.Slf4j;
import me.dineka.client_contact_service.dto.ContactRequestDTO;
import me.dineka.client_contact_service.mapper.ContactMapper;
import me.dineka.client_contact_service.model.Client;
import me.dineka.client_contact_service.model.Contact;
import me.dineka.client_contact_service.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public void addContact(Client client, ContactRequestDTO dto) {
        Contact contact = contactMapper.toEntity(dto);
        contact.setClient(client);
        contactRepository.save(contact);
        log.info("Клиенту с id {} добавлен контакт: телефон: {}, email: {}", client.getClientId(), contact.getPhone(), contact.getEmail());
    }
}
