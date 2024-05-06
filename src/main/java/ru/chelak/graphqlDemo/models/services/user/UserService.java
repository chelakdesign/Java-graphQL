package ru.aristov.graphqlDemo.services.user;

import ru.aristov.graphqlDemo.models.user.User;
import ru.aristov.graphqlDemo.services.BaseCRUDService;

import java.util.Optional;

public interface UserService extends BaseCRUDService<User> {
    public Optional<User> getUserByEmail(String email);

    public void softDeleteById(Integer id);
//    public void hardDeleteById(Integer id);
}
