package com.jmv.edoc.model.request;

import lombok.Data;

@Data
public class TopicRequest {
    private String topicNum;
    private String name;
    private Boolean isVisible;
}
