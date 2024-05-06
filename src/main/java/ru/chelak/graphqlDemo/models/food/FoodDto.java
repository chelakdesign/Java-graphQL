package ru.aristov.graphqlDemo.models.food;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FoodDto {
    private Integer id;

    private String name;

    private int calorie;

    private String description;

    private FoodStatus status;

    public Food toEntity() {
        return Food.builder()
            .id(id)
            .name(name)
            .calorie(calorie)
            .description(description)
            .status(status)
            .build();
    }

//    public static FoodDto fromEntity() {
//        return FoodDto
//    }
}
