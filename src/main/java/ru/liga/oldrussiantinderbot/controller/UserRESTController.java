package ru.liga.oldrussiantinderbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.oldrussiantinderbot.model.User;
import ru.liga.oldrussiantinderbot.repository.UserRepository;
import ru.liga.oldrussiantinderbot.service.UserService;
import ru.liga.oldrussiantinderbot.utils.Translator;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserRESTController {
    @Autowired
    private UserService userService;
    @Autowired
    private Translator translator;

    @GetMapping("/users")
    public List<User> getAllEmployees() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        user.setName(translator.translateInOldLanguage(user.getName()));
        user.setDescription(translator.translateInOldLanguage(user.getDescription()));
        user.setSex(translator.translateInOldLanguage(user.getSex()));
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user.getId());
        return "User with ID = " + id + " was deleted";
    }
    @PostMapping("/users/like/{ids}")
    public void likeUser(@PathVariable String ids){
        String[] split = ids.split("_");

        long current = Long.parseLong(split[0]);
        long target = Long.parseLong(split[1]);
        User currentUser = userService.getUser(current);
        User targetUser = userService.getUser(target);
        currentUser.getWeLike().add(targetUser);

        userService.saveUser(currentUser);
    }

    @GetMapping("/users/weLike/{id}")
    public Set<User> exportWeLike(@PathVariable Long id){
        User user = userService.getUser(id);
        return user.getWeLike();
    }
    @GetMapping("/users/whoLikedMe/{id}")
    public Set<User> exportWhoLikedMe(@PathVariable Long id){
        User user = userService.getUser(id);
        return user.getWhoLikedMe();
    }
}
