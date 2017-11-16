package lt.codeacademy.dao;

import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
    List<ShoppingList> findByUser(User user);

    @Modifying
    @Query("Update ShoppingList s SET s.name=:listName WHERE s.id=:listId")
    @Transactional
    ShoppingList updateShoppingList(@Param("listId") Long listId, @Param("listName") String listName);
}
