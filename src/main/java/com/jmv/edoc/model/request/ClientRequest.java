package com.jmv.edoc.model.request;

import lombok.Data;

@Data
public class ClientRequest {
    private Long clientId;
    private String name;
    private String lastName;
    private String email;
    private String comments;
}
