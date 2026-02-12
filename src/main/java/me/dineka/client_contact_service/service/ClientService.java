package me.dineka.client_contact_service.service;

import lombok.extern.slf4j.Slf4j;
import me.dineka.client_contact_service.dto.ClientRequestDTO;
import me.dineka.client_contact_service.dto.ClientResponseDTO;
import me.dineka.client_contact_service.exception.ClientAlreadyExistsException;
import me.dineka.client_contact_service.exception.ClientNotFoundException;
import me.dineka.client_contact_service.mapper.ClientMapper;
import me.dineka.client_contact_service.model.Client;
import me.dineka.client_contact_service.repository.ClientRepository;
import me.dineka.client_contact_service.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactService contactService;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ContactRepository contactRepository, ContactService contactService, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.contactService = contactService;
        this.clientMapper = clientMapper;
    }

    public void addClient(ClientRequestDTO dto) {
        Client client = clientMapper.toEntity(dto);
        clientRepository.save(client);
        log.info("Добавлен новый клиент: id: {}, имя: {}, фамилия: {}", client.getClientId(), client.getName(), client.getLastName());
    }

    public Client findById(Long id) {
        log.info("Поиск клиента с id {}", id);

        return clientRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Не удалось получить клиента с id {}, клиент не найден", id);
                    return new ClientNotFoundException("Клиент с id " + id + " не найден");
                });
    }

    public List<Client> getAll() {
        return new ArrayList<>(clientRepository.findAll());
    }

    public ClientResponseDTO updateClient(long clientId, ClientRequestDTO dto) {
        Client client = findById(clientId);
        clientMapper.toEntity(dto);
        return clientMapper.toDTO(client);
    }

    public void deleteClient(long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            log.info("Удален клиент с id {}", id);
        } else {
            log.warn("Не удалось удалить клиента с id {}, клиент не найден", id);
            throw new ClientNotFoundException("Клиент с id " + id + " не найден");
        }
    }

    public void validateClientRequestDTO(ClientRequestDTO dto) {
        if (clientRepository.existsByNameIgnoreCaseAndLastNameIgnoreCase(dto.getName(), dto.getLastName())) {
            throw new ClientAlreadyExistsException("Клиент с таким именем и фамилией уже существует");
        }
    }
}
