package com.jmv.edoc.service;

import com.jmv.edoc.model.entity.Doc;
import com.jmv.edoc.model.request.DocRequest;

import java.util.List;

public interface DocService {
    public String setAndUpdate(DocRequest docRequest);

    public Doc getById(Long id);

    public Doc getByRef(String ref);

    public List<Doc> getAllDocs();

    public String deleteById (Long id);
}
