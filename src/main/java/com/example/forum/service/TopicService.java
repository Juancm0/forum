package com.example.forum.service;

import com.example.forum.model.Topic;
import com.example.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> findAll() {
        return topicRepository.findAllByOrderByCreationDateDesc();
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}
