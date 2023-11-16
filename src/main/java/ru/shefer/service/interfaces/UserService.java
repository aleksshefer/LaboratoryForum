package ru.shefer.service.interfaces;

import ru.shefer.entities.Topic;
import ru.shefer.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> saveUser(User user);

    Optional<User> findUserById(long id);

    Optional<User> findUserByEmail(String email);

}
