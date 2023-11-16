package ru.shefer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shefer.entities.Topic;
import ru.shefer.entities.User;
import ru.shefer.service.interfaces.TopicService;
import ru.shefer.service.interfaces.UserService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Controller
public class CreateController {
    private final TopicService topicService;
    private final UserService userService;

    public CreateController(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }

    @GetMapping("/create-form")
    public String createForm() {
        return "create-form";
    }

    @PostMapping("/create")
    public String create(@RequestParam String topicName) {
        Topic topicToCreate = new Topic();
        topicToCreate.setName("test");
        Optional<User> shefer = userService.findUserByEmail("shefer");
        topicToCreate.setAuthor(shefer.get());
        topicToCreate.setCreationDate(Timestamp.from(Instant.now()));
        topicService.createTopic(topicToCreate);
        return "redirect:/";
    }
}
