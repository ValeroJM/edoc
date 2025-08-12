package com.jmv.edoc.controller;

import com.jmv.edoc.model.entity.Topic;
import com.jmv.edoc.model.request.TopicRequest;
import com.jmv.edoc.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/edoc")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * status: This Get Request method will return "OK" if the application is running
     * @return status OK
     */
    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    /**
     * createTopic: This Post Request method will create a Topic in the DB
     * @param topicRequest
     * @return status CREATED
     */
    @PostMapping("/topic")
    public ResponseEntity<String> createTopic(@RequestBody TopicRequest topicRequest){
        String status = topicService.setAndUpdate(topicRequest);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    /**
     * updateTopic: This Put Request method will update a Topic in the DB
     * @param topicRequest
     * @return status OK
     */
    @PutMapping("/topic")
    public ResponseEntity<String> updateTopic(@RequestBody TopicRequest topicRequest){
        String status = topicService.setAndUpdate(topicRequest);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/topic/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable Long id){
        Topic topic = topicService.getById(id);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics(){
        List<Topic> allTopics = topicService.getAllTopics();
        return new ResponseEntity<>(allTopics, HttpStatus.OK);
    }

    @DeleteMapping("/topic/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id){
        String status = topicService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
