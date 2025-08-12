package com.jmv.edoc.service;

import com.jmv.edoc.model.entity.Client;
import com.jmv.edoc.model.request.ClientRequest;

import java.util.List;

public interface ClientService {
    public String setAndUpdate(ClientRequest clientRequest);

    public Client getById(Long id);

    public Client getByEmail(String email);

    public List<Client> getAllClients();

    public String deleteById (Long id);
}
