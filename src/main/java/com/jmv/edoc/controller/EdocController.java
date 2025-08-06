package com.jmv.edoc.controller;

import com.jmv.edoc.model.entity.Doc;
import com.jmv.edoc.model.entity.Topic;
import com.jmv.edoc.model.request.DocRequest;
import com.jmv.edoc.model.request.Sale;
import com.jmv.edoc.model.request.TopicRequest;
import com.jmv.edoc.service.DocService;
import com.jmv.edoc.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/edoc")
public class EdocController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private DocService docService;

    @GetMapping("/status")
    public String status(){
        return "OK";
    }

    @PostMapping("/topic")
    public ResponseEntity<String> createTopic(@RequestBody TopicRequest topicRequest){
        String status = topicService.setAndUpdate(topicRequest);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

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

    @PostMapping("/doc")
    public ResponseEntity<String> createDoc(@RequestBody DocRequest docRequest){
        String status = docService.setAndUpdate(docRequest);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @PutMapping("/doc")
    public ResponseEntity<String> updateDoc(@RequestBody DocRequest docRequest){
        String status = docService.setAndUpdate(docRequest);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/doc/{id}")
    public ResponseEntity<DocRequest> getDoc(@PathVariable Long id){
        Doc doc = docService.getById(id);

        DocRequest docRequest = new DocRequest();
        docRequest.setDocId(doc.getDocId());
        docRequest.setRef(doc.getRef());
        docRequest.setDate(doc.getDate());
        docRequest.setTopicNum(doc.getTopicNum());
        docRequest.setName(doc.getName());
        docRequest.setImage(doc.getImage());
        docRequest.setDescription(doc.getDescription());
        docRequest.setAuthor(doc.getAuthor());
        docRequest.setStars(doc.getStars());

        Sale sale = new Sale();
        sale.setInSale(doc.getInSale());
        sale.setPrice1(doc.getPrice1());
        sale.setPrice2(doc.getPrice2());

        docRequest.setSale(sale);

        return new ResponseEntity<>(docRequest, HttpStatus.OK);
    }

    @GetMapping("/docBy/{ref}")
    public ResponseEntity<DocRequest> getDocByRef(@PathVariable String ref){
        Doc doc = docService.getByRef(ref);
        DocRequest docRequest = new DocRequest();
        docRequest.setDocId(doc.getDocId());
        docRequest.setRef(doc.getRef());
        docRequest.setDate(doc.getDate());
        docRequest.setTopicNum(doc.getTopicNum());
        docRequest.setName(doc.getName());
        docRequest.setImage(doc.getImage());
        docRequest.setDescription(doc.getDescription());
        docRequest.setAuthor(doc.getAuthor());
        docRequest.setStars(doc.getStars());

        Sale sale = new Sale();
        sale.setInSale(doc.getInSale());
        sale.setPrice1(doc.getPrice1());
        sale.setPrice2(doc.getPrice2());

        docRequest.setSale(sale);
        return new ResponseEntity<>(docRequest, HttpStatus.OK);
    }

    @GetMapping("/docs")
    public ResponseEntity<List<DocRequest>> getAllDocs(){
        List<Doc> docs = docService.getAllDocs();
        List<DocRequest> allDocs = new ArrayList<>();

        for(Doc doc: docs){
            DocRequest docRequest = new DocRequest();
            Sale sale = new Sale();

            docRequest.setDocId(doc.getDocId());
            docRequest.setRef(doc.getRef());
            docRequest.setDate(doc.getDate());
            docRequest.setTopicNum(doc.getTopicNum());
            docRequest.setName(doc.getName());
            docRequest.setImage(doc.getImage());
            docRequest.setDescription(docRequest.getDescription());
            docRequest.setAuthor(doc.getAuthor());
            docRequest.setStars(doc.getStars());

            sale.setInSale(doc.getInSale());
            sale.setPrice1(doc.getPrice1());
            sale.setPrice2(doc.getPrice2());

            docRequest.setSale(sale);

            allDocs.add(docRequest);
        }
        return new ResponseEntity<>(allDocs, HttpStatus.OK);
    }

    @DeleteMapping("/doc/{id}")
    public ResponseEntity<String> deleteDoc(@PathVariable Long id){
        String status = docService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
