package me.dineka.client_contact_service.repository;

import me.dineka.client_contact_service.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
