package com.jmv.edoc.service;

import com.jmv.edoc.model.entity.Doc;
import com.jmv.edoc.model.request.DocRequest;
import com.jmv.edoc.repository.DocRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DocServiceImp implements DocService{
    @Autowired
    DocRepository docRepository;

    @Override
    public String setAndUpdate(DocRequest docRequest) {
        Doc doc = new Doc();
        doc.setDocId(docRequest.getDocId());
        doc.setRef(docRequest.getRef());
        doc.setDate(docRequest.getDate());
        doc.setTopicNum(docRequest.getTopicNum());
        doc.setName(docRequest.getName());
        doc.setImage(docRequest.getImage());
        doc.setDescription(docRequest.getDescription());
        doc.setAuthor(docRequest.getAuthor());
        doc.setStars(docRequest.getStars());
        doc.setInSale(docRequest.getSale().getInSale());
        doc.setPrice1(docRequest.getSale().getPrice1());
        doc.setPrice2(docRequest.getSale().getPrice2());

        docRepository.save(doc);

        log.info(">> Doc was added/updated to the DB: " + doc);

        return "Success";
    }

    @Override
    public Doc getById(Long id) {
        Optional<Doc> findById = docRepository.findById(id);

        if(findById.isPresent()){
            log.info(">> Doc with id: " + id + " was found: " + findById.get());
            return findById.get();
        }

        log.info(">> Doc with id: " + id + " was NOT found");
        return null;
    }

    @Override
    public Doc getByRef(String ref) {
        Optional<Doc> findByRef = docRepository.findByRef(ref);

        if(findByRef.isPresent()){
            log.info(">> Doc with ref: " + ref + " was found: " + findByRef.get());
            return findByRef.get();
        }

        log.info(">> Doc with ref: " + ref + " was NOT found");
        return null;
    }

    @Override
    public List<Doc> getAllDocs() {
        log.info(">> Doc Total number list is: " + docRepository.count());
        return docRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if(docRepository.existsById(id)){
            docRepository.deleteById(id);
            log.info(">> Doc with id: " + id + " is successfully deleted");
            return "Delete Success";
        }else {
            log.info(">> Doc with id: " + id + " is NOT found");
            return "No Doc Found";
        }
    }
}
