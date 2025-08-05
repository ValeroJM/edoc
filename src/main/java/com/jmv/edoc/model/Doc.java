package com.jmv.edoc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "EDOC_DOC")
public class Doc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;
    private String ref;
    private String date;
    private String topicNum;
    private String name;
    private String image;
    private String description;
    private String author;
    private Integer stars;
    private Boolean inSale;
    private Double price1;
    private Double price2;
}
