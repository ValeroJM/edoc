package com.jmv.edoc.service;

import com.jmv.edoc.model.Topic;

import java.util.List;

public interface TopicService {

    public String setAndUpdate(Topic topic);

    public Topic getById(Long id);

    public List<Topic> getAllTopics();

    public String deleteById (Long id);
}
