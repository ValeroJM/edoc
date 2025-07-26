package com.jmv.edoc.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "EDOC_TOPIC")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topicId;
    private String name;
    private Boolean isVisible;
}
