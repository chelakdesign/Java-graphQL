package ru.aristov.graphqlDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.aristov.graphqlDemo.models.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findUserByEmail(String email);

    @Modifying
    @Query("UPDATE Food SET description = 'DELETE' WHERE id = :id")
//    @Query("select status from User where id = :id")
    public void deactivateUser(Integer id);
}
