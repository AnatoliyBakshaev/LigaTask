
package com.library.ligatask.service;
import com.library.ligatask.exception.Exep;
import com.library.ligatask.entity.Client;
import com.library.ligatask.repository.RepositoryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClient {

    private final RepositoryClient clientRepository;

    public ServiceClient(RepositoryClient clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new Exep(id));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }


    public Client updateClient(Long id, Client updatedClient) {
        Client client = getClientById(id);
        if (updatedClient.getFullName() != null) {
            if (updatedClient.getFullName().isBlank()) {
                throw new IllegalArgumentException("фио не может быть пустым");
            }
            client.setFullName(updatedClient.getFullName());
        }
        if (updatedClient.getStatus() != null) {
            client.setStatus(updatedClient.getStatus());
        }
        if (updatedClient.getFullName() == null
                && updatedClient.getStatus() == null) {
            throw new IllegalArgumentException(
                    "надо передать фио или статус для обновления");
        }
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}
