package ru.aristov.graphqlDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aristov.graphqlDemo.models.food.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
