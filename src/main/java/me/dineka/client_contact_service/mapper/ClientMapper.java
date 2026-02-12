package me.dineka.client_contact_service.mapper;

import me.dineka.client_contact_service.dto.ClientRequestDTO;
import me.dineka.client_contact_service.dto.ClientResponseDTO;
import me.dineka.client_contact_service.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toEntity(ClientRequestDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setLastName(dto.getLastName());
        return client;
    }

    public ClientResponseDTO toDTO(Client client) {
        ClientResponseDTO dto = new ClientResponseDTO();
        return null;
    }
}
