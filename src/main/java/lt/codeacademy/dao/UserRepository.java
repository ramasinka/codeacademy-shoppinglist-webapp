package lt.codeacademy.dao;

import lt.codeacademy.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {

    User findUserByNameAndPassword(String name, String password);

    User findUserByEmail(String email);
}