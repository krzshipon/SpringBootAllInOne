package com.shipon.completespringboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepo repo;

    public List<Topic> getAllTopics(){
        List<Topic> topics= new ArrayList<>();
        repo.findAll().forEach(topics::add);

        return topics;
    }

    public Optional<Topic> getTopic(int id) {
        return repo.findById(id);
    }


    public Topic addTopic(Topic topic) {
        repo.save(topic);
        return topic;
    }
    public Optional<Topic> updateTopic(Topic topic) {
        repo.save(topic);
        return repo.findById(topic.getId());
    }

    public void deleteTopic(Topic topic) {
        repo.delete(topic);
    }
}
