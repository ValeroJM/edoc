package com.jmv.edoc.model.request;

import lombok.Data;

@Data
public class TopicRequest {
    private Long topicId;
    private String topicNum;
    private String name;
    private Boolean isVisible;
}
