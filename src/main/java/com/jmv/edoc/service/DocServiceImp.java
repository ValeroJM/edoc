package com.jmv.edoc.service;

import com.jmv.edoc.model.Doc;
import com.jmv.edoc.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocServiceImp implements DocService{
    @Autowired
    DocRepository docRepository;

    @Override
    public String setAndUpdate(Doc doc) {
        docRepository.save(doc);
        return "Success";
    }

    @Override
    public Doc getById(Long id) {
        Optional<Doc> findById = docRepository.findById(id);

        if(findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public Doc getByRef(String ref) {
        Optional<Doc> findByRef = docRepository.findByRef(ref);

        if(findByRef.isPresent()){
            return findByRef.get();
        }
        return null;
    }

    @Override
    public List<Doc> getAllDocs() {
        return docRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if(docRepository.existsById(id)){
            docRepository.deleteById(id);
            return "Delete Success";
        }else {
            return "No Topic Found";
        }
    }
}
