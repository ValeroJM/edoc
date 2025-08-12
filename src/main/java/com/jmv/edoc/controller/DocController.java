package com.jmv.edoc.controller;

import com.jmv.edoc.model.entity.Doc;
import com.jmv.edoc.model.request.DocRequest;
import com.jmv.edoc.model.request.Sale;
import com.jmv.edoc.service.DocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/edoc")
public class DocController {

    @Autowired
    private DocService docService;

    /**
     * createDoc: This Post Request method will create a Doc in the DB
     * @param docRequest
     * @return status CREATED
     */
    @PostMapping("/doc")
    public ResponseEntity<String> createDoc(@RequestBody DocRequest docRequest){
        String status = docService.setAndUpdate(docRequest);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    /**
     * updateDoc: This Put Request method will update a Doc in the DB
     * @param docRequest
     * @return status OK
     */
    @PutMapping("/doc")
    public ResponseEntity<String> updateDoc(@RequestBody DocRequest docRequest){
        String status = docService.setAndUpdate(docRequest);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    /**
     * getDoc: This Get Request method will return a Doc by ID
     * @param id
     * @return status OK
     */
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

    /**
     * getDocByRef: This Get Request method will return a Doc by Reference
     * @param ref
     * @return status OK
     */
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

    /**
     * getAllDocs: This Get Request method will return all Docs from DB
     * @return status OK
     */
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

    /**
     * deleteDoc: This Delete Request method will delete a Doc from DB using its ID
     * @param id
     * @return status OK
     */
    @DeleteMapping("/doc/{id}")
    public ResponseEntity<String> deleteDoc(@PathVariable Long id){
        String status = docService.deleteById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
