package com.jmv.edoc.service;

import com.jmv.edoc.model.entity.Client;
import com.jmv.edoc.model.entity.Doc;
import com.jmv.edoc.model.request.ClientRequest;
import com.jmv.edoc.model.request.DocRequest;
import com.jmv.edoc.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientServiceImp implements ClientService{
    @Autowired
    ClientRepository clientRepository;

    @Override
    public String setAndUpdate(ClientRequest clientRequest) {
        Client client = new Client();
        client.setClientId(clientRequest.getClientId());
        client.setName(clientRequest.getName());
        client.setLastName(clientRequest.getLastName());
        client.setEmail(clientRequest.getEmail());
        client.setComments(clientRequest.getComments());
        clientRepository.save(client);
        log.info(">> Client was added/updated to the DB: " + client);
        return "Success";
    }

    @Override
    public Client getById(Long id) {
        Optional<Client> findById = clientRepository.findById(id);

        if(findById.isPresent()){
            log.info(">> Client with id: " + id + " was found: " + findById.get());
            return findById.get();
        }

        log.info(">> Client with id: " + id + " was NOT found");
        return null;
    }

    @Override
    public Client getByEmail(String email) {
        Optional<Client> findByEmail = clientRepository.findByEmail(email);

        if(findByEmail.isPresent()){
            log.info(">> Client with email: " + email + " was found: " + findByEmail.get());
            return findByEmail.get();
        }

        log.info(">> Client with email: " + email + " was NOT found");
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        log.info(">> Client Total number list is: " + clientRepository.count());
        return clientRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            log.info(">> Client with id: " + id + " is successfully deleted");
            return "Delete Success";
        }else {
            log.info(">> Client with id: " + id + " is NOT found");
            return "No Client Found";
        }
    }
}
