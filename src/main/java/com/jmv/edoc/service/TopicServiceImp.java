package com.jmv.edoc.service;

import com.jmv.edoc.model.entity.Topic;
import com.jmv.edoc.model.request.TopicRequest;
import com.jmv.edoc.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TopicServiceImp implements TopicService{
    @Autowired
    TopicRepository topicRepository;

    @Override
    public String setAndUpdate(TopicRequest topicRequest) {
        Topic topic = new Topic();
        topic.setTopicId(topicRequest.getTopicId());
        topic.setTopicNum(topicRequest.getTopicNum());
        topic.setName(topicRequest.getName());
        topic.setIsVisible(topicRequest.getIsVisible());
        topicRepository.save(topic);

        log.info(">> Topic was added/updated to the DB: " + topic);

        return "Success";
    }

    @Override
    public Topic getById(Long id) {
        Optional<Topic> findById = topicRepository.findById(id);

        if(findById.isPresent()){
            log.info(">> Topic with id: " + id + " was found: " + findById.get());
            return findById.get();
        }

        log.info(">> Topic with id: " + id + " was NOT found");
        return null;
    }

    @Override
    public List<Topic> getAllTopics() {
        log.info(">> Topic Total number list is: " + topicRepository.count());
        return topicRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if(topicRepository.existsById(id)){
            topicRepository.deleteById(id);
            log.info(">> Topic with id: " + id + " is successfully deleted");
            return "Delete Success";
        }else {
            log.info(">> Topic with id: " + id + " is NOT found");
            return "No Topic Found";
        }
    }
}
