package com.jmv.edoc.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "EDOC_TOPIC")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;
    private String topicNum;
    private String name;
    private Boolean isVisible;
}
