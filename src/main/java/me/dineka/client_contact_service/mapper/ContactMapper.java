package me.dineka.client_contact_service.mapper;

import me.dineka.client_contact_service.dto.ContactRequestDTO;
import me.dineka.client_contact_service.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public Contact toEntity(ContactRequestDTO dto) {
        Contact contact = new Contact();
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        return contact;
    }
}
