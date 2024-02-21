package ru.proskurnin.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.proskurnin.core.service.UserService;
import ru.proskurnin.core.config.ConfigData;
import ru.proskurnin.core.entity.User;

public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigData.class);
        final UserService userService = context.getBean(UserService.class);
        final User user = new User(2L, "Наталья Михайлова");

        userService.createUser(user);
        userService.getUserById(user.getId());
        userService.getAllUsers();
        userService.updateUser(new User(4L, "Михаил Прохоров"));
        userService.deleteUser(user.getId());
    }
}
