package ru.aristov.graphqlDemo.controllers;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aristov.graphqlDemo.models.user.User;
import ru.aristov.graphqlDemo.models.user.UserDto;
import ru.aristov.graphqlDemo.services.user.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@GraphQLApi
public class UserResolver{
    private final UserService userService;

    @GraphQLQuery(name = "userReadItem")
    public Optional<User> userReadItem(@GraphQLArgument(name = "id") Integer id) {
        return userService.getById(id);
    }

    @GraphQLQuery(name = "userReadList")
    public List<User> userReadList() {
        return userService.getAll();
    }

    @GraphQLMutation(name = "userCreateItem")
    public User userCreateItem(@GraphQLArgument(name = "userDto") UserDto userDto) {
        return userService.create(userDto.toEntity());
    }

    @GraphQLMutation(name = "userUpdateItem")
    public User userUpdateItem(@GraphQLArgument(name = "userDto") UserDto userDto) {
        return userService.update(userDto.toEntity());
    }

    @GraphQLMutation(name = "userDeleteItem")
    public void userDeleteItem(
            @GraphQLArgument(name = "id") Integer id,
            @GraphQLArgument(name = "isSoft", defaultValue = "true") Boolean isSoft
    ) {
        if (isSoft) {
            userService.softDeleteById(id);
        } else {
            userService.deleteById(id);
        }
    }
}
