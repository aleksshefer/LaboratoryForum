package ru.shefer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shefer.entities.User;
import ru.shefer.service.interfaces.TopicService;
import ru.shefer.service.interfaces.UserService;

@Controller
public class IndexController {
    private final TopicService topicService;
    private final UserService userService;

    public IndexController(TopicService topicService, UserService userService) {
        this.topicService = topicService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("topics", topicService.findAllTopics());
        return "index";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }

    @PostMapping("/login")
    public String login() {
        System.out.println(111);
        User userToCreate = new User();
        userToCreate.setName("alex");
        userToCreate.setEmail("shefer");
        userToCreate.setSurname("shefer");
        userToCreate.setPassword("12345");
        userService.saveUser(userToCreate);
        return "redirect:/";
    }
}
