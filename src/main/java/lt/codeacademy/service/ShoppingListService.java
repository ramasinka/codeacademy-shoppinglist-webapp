package lt.codeacademy.service;

import lt.codeacademy.dao.ShoppingListRepository;
import lt.codeacademy.model.ShoppingList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShoppingListService {

    @Resource
    ShoppingListRepository shoppingListRepository;

    public boolean isShoppingListExists(long listId) {
        ShoppingList shoppingList = shoppingListRepository.findOne(listId);
        if (shoppingList == null) {
            throw new RuntimeException("Shopping list does not exist");
        }
        return true;
    }

    public ShoppingList findShoppingListById(long listId) {
        return shoppingListRepository.findOne(listId);
    }
}
