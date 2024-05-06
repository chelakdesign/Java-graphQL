package ru.chelak.graphqlDemo.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto{
    private Integer id;

    private String nameFirst;

    private String nameSecond;

    private String nameMiddle;

    private String email;

    private String password;

    private UserStatus status;

    public User toEntity() {
        return User.builder()
                .id(id)
                .nameFirst(nameFirst)
                .nameSecond(nameSecond)
                .nameMiddle(nameMiddle)
                .email(email)
                .password(password)
                .status(status)
                .build();
    }

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .nameFirst(user.getNameFirst())
                .nameSecond(user.getNameSecond())
                .nameMiddle(user.getNameMiddle())
                .email(user.getEmail())
                .password(user.getPassword())
                .status(user.getStatus())
                .build();
    }
}
