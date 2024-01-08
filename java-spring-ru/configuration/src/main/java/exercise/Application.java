package exercise;

import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.User;
import exercise.component.UserProperties;

@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();
    // BEGIN
    @Autowired
    private UserProperties adminsProp;
    @GetMapping("/admins")
    public List<String> getAdminsEmail() {
        List<String> adminEmails = adminsProp.getAdmins();
        List<String> adminNames = users.stream()
                .filter(user -> adminEmails.contains(user.getEmail()))
                .map(User::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return adminNames;
    }
    // END

    @GetMapping("/users")
    public List<User> index() {
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Long id) {
        var user = users.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
