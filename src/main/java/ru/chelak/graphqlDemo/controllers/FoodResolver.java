package ru.chelak.graphqlDemo.controllers;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.chelak.graphqlDemo.models.food.Food;
import ru.chelak.graphqlDemo.models.food.FoodDto;
import ru.chelak.graphqlDemo.services.food.FoodServiceImpl;

import java.util.List;
import java.util.Optional;

@GraphQLApi
@Controller
@RequiredArgsConstructor
public class FoodResolver {
    private final FoodServiceImpl foodService;

    @GraphQLQuery(name = "foodReadItem")
    public Optional<Food> foodReadItem(@GraphQLArgument(name = "id") Integer id) {
        return foodService.getById(id);
    }

    @GraphQLQuery(name = "foodReadList")
    public List<Food> foodReadList() {
        return foodService.getAll();
    }

    @GraphQLMutation(name = "foodCreateItem")
    public Food foodCreateItem(@GraphQLArgument(name = "foodDto") FoodDto foodDto) {
        return foodService.create(foodDto.toEntity());
    }
    @GraphQLMutation(name = "foodUpdateItem")
    public Food foodUpdateItem(@GraphQLArgument(name = "foodDto") FoodDto foodDto) {
        return foodService.update(foodDto.toEntity());
    }

    @GraphQLMutation(name = "foodDeleteItem")
    public void foodDeleteItem(@GraphQLArgument(name = "id") Integer id) {
        foodService.deleteById(id);
    }
}
