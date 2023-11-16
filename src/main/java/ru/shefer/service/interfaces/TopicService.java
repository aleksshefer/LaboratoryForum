package ru.shefer.service.interfaces;

import ru.shefer.entities.Topic;
import ru.shefer.entities.User;

import java.util.List;
import java.util.Optional;

public interface TopicService {

    Optional<Topic> createTopic(Topic topic);

    List<Topic> findTopicByUser(User user);

    List<Topic> findAllTopics();
}
