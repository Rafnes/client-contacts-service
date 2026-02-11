package me.dineka.client_contact_service.repository;

import me.dineka.client_contact_service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByNameIgnoreCaseAndLastNameIgnoreCase(String name, String lastName);
}
