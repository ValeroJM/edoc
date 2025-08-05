package com.jmv.edoc.model.request;

import lombok.Data;

@Data
public class DocRequest {
    private Long docId;
    private String ref;
    private String date;
    private String topicNum;
    private String name;
    private String image;
    private String description;
    private String author;
    private Integer stars;
    private Sale sale;
}
