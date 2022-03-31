package ru.liga.oldrussiantinderbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.oldrussiantinderbot.model.User;
import ru.liga.oldrussiantinderbot.repository.UserRepository;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        User user = null;
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()){
            user = byId.get();
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
