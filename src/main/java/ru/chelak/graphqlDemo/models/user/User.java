package ru.aristov.graphqlDemo.models.user;

import jakarta.persistence.*;
import lombok.*;
import ru.aristov.graphqlDemo.models.food.Food;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameFirst;

    private String nameSecond;

    private String nameMiddle;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "user")
    private List<Food> food;
}
