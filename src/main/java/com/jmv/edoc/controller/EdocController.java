package com.jmv.edoc.controller;

import com.jmv.edoc.model.Topic;
import com.jmv.edoc.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/edoc")
public class EdocController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    @PostMapping("/topic")
    public ResponseEntity<String> createTopic(@RequestBody Topic topic){
        String status = topicService.setAndUpdate(topic);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @PutMapping("/topic")
    public ResponseEntity<String> updateTopic(@RequestBody Topic topic){
        String status = topicService.setAndUpdate(topic);
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
