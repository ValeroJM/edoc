package com.jmv.edoc.repository;

import com.jmv.edoc.model.entity.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocRepository extends JpaRepository<Doc, Long> {
    Optional<Doc> findByRef(String ref);
}
