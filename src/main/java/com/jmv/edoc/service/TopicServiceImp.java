package com.jmv.edoc.service;

import com.jmv.edoc.model.Topic;
import com.jmv.edoc.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImp implements TopicService{
    @Autowired
    TopicRepository topicRepository;

    @Override
    public String setAndUpdate(Topic topic) {
        topicRepository.save(topic);
        return "Success";
    }

    @Override
    public Topic getById(Long id) {
        Optional<Topic> findById = topicRepository.findById(id);

        if(findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if(topicRepository.existsById(id)){
            topicRepository.deleteById(id);
            return "Delete Success";
        }else {
            return "No Topic Found";
        }
    }
}
