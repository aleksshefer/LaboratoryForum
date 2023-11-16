package ru.shefer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shefer.entities.Topic;
import ru.shefer.entities.User;

import java.util.List;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByAuthor(User user);
}
