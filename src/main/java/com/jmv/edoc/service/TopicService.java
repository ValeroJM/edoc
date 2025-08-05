package com.jmv.edoc.service;

import com.jmv.edoc.model.entity.Topic;
import com.jmv.edoc.model.request.TopicRequest;

import java.util.List;

public interface TopicService {

    public String setAndUpdate(TopicRequest topicRequest);

    public Topic getById(Long id);

    public List<Topic> getAllTopics();

    public String deleteById (Long id);
}
