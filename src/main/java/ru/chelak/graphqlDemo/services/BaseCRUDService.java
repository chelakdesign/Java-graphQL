package ru.chelak.graphqlDemo.services;

import java.util.List;
import java.util.Optional;

public interface BaseCRUDService<T> {
    public List<T> getAll();

    public Optional<T> getById(Integer id);

    public T create(T entity);

    public T update(T entity);

    void deleteById(Integer id);
}
