
package com.library.ligatask.controller;

import com.library.ligatask.dto.ClientCreateRequest;
import com.library.ligatask.dto.ClientUpdateRequest;
import com.library.ligatask.dto.ClientResponse;
import com.library.ligatask.entity.Client;
import com.library.ligatask.service.ServiceClient;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ServiceClient clientService;

    public ClientController(ServiceClient clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(
            @Valid @RequestBody ClientCreateRequest request) {

        Client client = new Client();
        client.setFullName(request.getFullName());
        client.setGender(request.getGender());

        Client savedClient = clientService.createClient(client);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(savedClient));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients() {

        List<ClientResponse> clients = clientService.getAllClients()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(
            @PathVariable Long id) {

        Client client = clientService.getClientById(id);

        return ResponseEntity.ok(toResponse(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(
            @PathVariable Long id,
            @RequestBody ClientUpdateRequest request) {

        Client updatedClient = new Client();
        updatedClient.setFullName(request.getFullName());
        updatedClient.setStatus(request.getStatus());

        Client client = clientService.updateClient(id, updatedClient);

        return ResponseEntity.ok(toResponse(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(
            @PathVariable Long id) {

        clientService.deleteClient(id);

        return ResponseEntity.noContent().build();
    }

    private ClientResponse toResponse(Client client) {

        ClientResponse response = new ClientResponse();

        response.setId(client.getId());
        response.setFullName(client.getFullName());
        response.setGender(client.getGender());
        response.setStatus(client.getStatus());
        response.setCreateDttm(client.getCreateDttm());
        response.setModifyDttm(client.getModifyDttm());

        return response;
    }
}
