package ru.chelak.graphqlDemo.services.user;

import ru.chelak.graphqlDemo.models.user.User;
import ru.chelak.graphqlDemo.services.BaseCRUDService;

import java.util.Optional;

public interface UserService extends BaseCRUDService<User> {
    public Optional<User> getUserByEmail(String email);

    public void softDeleteById(Integer id);
//    public void hardDeleteById(Integer id);
}
