package ru.aristov.graphqlDemo.models.food;

import jakarta.persistence.*;
import lombok.*;
import ru.aristov.graphqlDemo.models.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Food {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int calorie;

    private String description;

    @Enumerated(EnumType.STRING)
    private FoodStatus status;

//    @ManyToOne()
//    @MapsId("myUserId")
//    private User user;
//
//    @Column(name = "myUserId", nullable = false)
//    private Integer myUserId;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;
}
