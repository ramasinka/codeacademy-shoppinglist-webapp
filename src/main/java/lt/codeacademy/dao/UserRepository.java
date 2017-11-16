package lt.codeacademy.dao;

import lt.codeacademy.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByName(String name);

    User findUserByEmail(String email);

    @Modifying
    @Query("Update User u SET u.email=:email, u.name = :name WHERE u.id=:id")
    @Transactional
    User updateUser(@Param("id") long id, @Param("email") String email, @Param("name") String name);
}