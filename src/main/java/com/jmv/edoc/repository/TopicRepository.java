package com.jmv.edoc.repository;

import com.jmv.edoc.model.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
