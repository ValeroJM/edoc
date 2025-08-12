package com.jmv.edoc.controller;

import com.jmv.edoc.model.entity.Client;
import com.jmv.edoc.model.request.ClientRequest;
import com.jmv.edoc.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/edoc")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * createClient: This Post Request method will create a Client in the DB
     * @param clientRequest
     * @return status CREATED
     */
    @PostMapping("/client")
    public ResponseEntity<String> createClient(@RequestBody ClientRequest clientRequest){
        String status = clientService.setAndUpdate(clientRequest);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    /**
     * updateClient: This Put Request method will update a Client in the DB
     * @param clientRequest
     * @return status OK
     */
    @PutMapping("/client")
    public ResponseEntity<String> updateClient(@RequestBody ClientRequest clientRequest){
        String status = clientService.setAndUpdate(clientRequest);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    /**
     * getClient: This Get Request method will return a Client by ID
     * @param id
     * @return status OK
     */
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        Client client = clientService.getById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    /**
     * getClientByEmail: This Get Request method will return a Client by Email
     * @param email
     * @return status OK
     */
    @GetMapping("/clientBy/{email}")
    public ResponseEntity<Client> getClientByEmail(@PathVariable String email){
        Client client = clientService.getByEmail(email);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    /**
     * getAllClients: This Get Request method will return all Clients from DB
     * @return status OK
     */
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clientList = clientService.getAllClients();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    /**
     * deleteClient: This Delete Request method will delete a client from DB using its ID
     * @param id
     * @return status OK
     */
    @DeleteMapping("/client/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id){
        String status = clientService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
