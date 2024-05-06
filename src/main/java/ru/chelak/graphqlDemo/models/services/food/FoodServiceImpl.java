package ru.aristov.graphqlDemo.services.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aristov.graphqlDemo.models.food.Food;
import ru.aristov.graphqlDemo.repositories.FoodRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
    private final FoodRepository foodRepository;
    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> getById(Integer id) {
        return foodRepository.findById(id);
    }

    @Override
    public Food create(Food entity) {
        return foodRepository.save(entity);
    }

    @Override
    public Food update(Food entity) {
        return foodRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        Food food = foodRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Food not found"));

        foodRepository.deleteById(id);
    }
}
