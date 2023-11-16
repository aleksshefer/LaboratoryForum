package ru.shefer.service;

import org.springframework.stereotype.Service;
import ru.shefer.entities.Topic;
import ru.shefer.entities.User;
import ru.shefer.repository.TopicRepository;
import ru.shefer.service.interfaces.TopicService;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Optional<Topic> createTopic(Topic topic) {
        return Optional.of(topicRepository.save(topic));
    }

    @Override
    public List<Topic> findTopicByUser(User user) {
        return topicRepository.findAllByAuthor(user);
    }

    @Override
    public List<Topic> findAllTopics() {
        return topicRepository.findAll();
    }
}
