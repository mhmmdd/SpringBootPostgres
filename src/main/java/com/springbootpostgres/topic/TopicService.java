package com.springbootpostgres.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mhmmdd on 15.03.2017.
 */
@Service
public class TopicService {

    public List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("spring", "Spring Framework", "Description"),
                new Topic("java", "Core Java", "Description")
        ));

    public List<Topic> getAllTopics () {
        return this.topics;
    }

    public Topic getTopic(String id) {
        return this.topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if(t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
