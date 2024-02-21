package ru.proskurnin.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.proskurnin.core.entity.User;

import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public User getUserById(Long userId) {
        final User userById = userDAO.getUserById(userId);
        return userById;
    }

    public List<User> getAllUsers() {
        final List<User> allUsers = userDAO.getAllUsers();
        return allUsers;
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(Long userId) {
        userDAO.deleteUser(userId);
    }
}
