package com.example.forum.controller;

import com.example.forum.model.Topic;
import com.example.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.save(topic);
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable Long id) {
        return topicService.findById(id);
    }

    @PutMapping("/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody Topic updatedTopic) {
        Topic topic = topicService.findById(id);
        if (topic != null) {
            topic.setTitle(updatedTopic.getTitle());
            topic.setMessage(updatedTopic.getMessage());
            topic.setStatus(updatedTopic.getStatus());
            topic.setCourse(updatedTopic.getCourse());
            return topicService.save(topic);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteById(id);
    }
}
