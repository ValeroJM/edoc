package com.jmv.edoc.service;

import com.jmv.edoc.model.Doc;

import java.util.List;

public interface DocService {
    public String setAndUpdate(Doc doc);

    public Doc getById(Long id);

    public Doc getByRef(String ref);

    public List<Doc> getAllDocs();

    public String deleteById (Long id);
}
