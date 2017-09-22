package lt.codeacademy.dao;

import lt.codeacademy.model.ProductItem;
import lt.codeacademy.model.ShoppingList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductItemRepository extends CrudRepository<ProductItem, Long> {

    List<ProductItem> findByShoppingList(ShoppingList shoppingList);

    @Modifying
    @Query("Update ProductItem p SET p.pname=:productName, p.pamount=:pamount, p.pprice=:pprice WHERE p.id=:itemId")
    @Transactional
    void updateProductItem(@Param("itemId") long itemId,
                           @Param("productName") String productName,
                           @Param("pamount") int pamount,
                           @Param("pprice") int pprice);
}
