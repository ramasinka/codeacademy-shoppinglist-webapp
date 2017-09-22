package lt.codeacademy.dao;

import lt.codeacademy.model.ShareSummary;
import lt.codeacademy.model.ShoppingList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShareRepository extends CrudRepository<ShareSummary, Long> {
    ShareSummary findByEmailAndListId(String email, long listId);

    @Modifying
    @Query("Update ShareSummary s SET s.status=:status WHERE s.id=:id")
    @Transactional
    void update(@Param("id") long id, @Param("status") String status);

    @Query("SELECT s FROM ShoppingList s WHERE s.id = " +
            "(SELECT sh.listId FROM ShareSummary sh WHERE sh.toUserId = :userId AND sh.status = 'Confirmed')")
    List<ShoppingList> findSharedShoppingLists(@Param("userId") long userId);
}
