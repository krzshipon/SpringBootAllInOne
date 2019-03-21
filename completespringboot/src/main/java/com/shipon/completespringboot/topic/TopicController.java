package com.shipon.completespringboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopic(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable int id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public Topic addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
        return topic;
    }
    @PutMapping("/topics")
    public Optional<Topic> updateTopic(@RequestBody Topic topic){
        Optional<Topic> topic1=topicService.updateTopic(topic);
        return topic1;
    }

    @DeleteMapping("/topics")
    public String deleteTopic(@RequestBody Topic topic){
        topicService.deleteTopic(topic);
        return "removed";
    }
}
