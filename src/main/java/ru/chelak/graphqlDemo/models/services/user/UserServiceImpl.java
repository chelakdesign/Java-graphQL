package ru.aristov.graphqlDemo.services.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aristov.graphqlDemo.models.user.User;
import ru.aristov.graphqlDemo.models.user.UserStatus;
import ru.aristov.graphqlDemo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(User entity) {
        entity.setStatus(UserStatus.ACTIVE);
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }



    @Override
    public void softDeleteById(Integer id) {
        userRepository.deactivateUser(id);
//        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
//
//        user.setStatus(UserStatus.DELETE);
//        userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
