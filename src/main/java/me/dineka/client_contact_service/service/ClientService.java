package me.dineka.client_contact_service.service;

import lombok.extern.slf4j.Slf4j;
import me.dineka.client_contact_service.dto.ClientRequestDTO;
import me.dineka.client_contact_service.exception.ClientAlreadyExistsException;
import me.dineka.client_contact_service.mapper.ClientMapper;
import me.dineka.client_contact_service.model.Client;
import me.dineka.client_contact_service.repository.ClientRepository;
import me.dineka.client_contact_service.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ContactRepository contactRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
        this.clientMapper = clientMapper;
    }

    public void addClient(ClientRequestDTO dto) {
        Client client = clientMapper.toEntity(dto);
        clientRepository.save(client);
        log.info("Добавлен новый клиент: id: {}, имя: {}, фамилия: {}", client.getClientId(), client.getName(), client.getLastName());
    }

    public void validateClientRequestDTO(ClientRequestDTO dto) {
        if (clientRepository.existsByNameIgnoreCaseAndLastNameIgnoreCase(dto.getName(), dto.getLastName())) {
            throw new ClientAlreadyExistsException("Клиент с таким именем и фамилией уже существует");
        }
    }
}
