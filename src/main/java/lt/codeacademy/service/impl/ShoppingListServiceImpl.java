package lt.codeacademy.service.impl;

import lt.codeacademy.dao.ShoppingListRepository;
import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.model.User;
import lt.codeacademy.service.ShoppingListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    @Resource
    private ShoppingListRepository shoppingListRepository;

    @Resource
    private UserRepository userRepository;

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

    @Override
    public Iterable<ShoppingList> getAllShoppingLists() {
        return shoppingListRepository.findAll();
    }

    @Override
    public ShoppingList getShoppingList(long id) {
        return shoppingListRepository.findOne(id);
    }

    @Override
    public ShoppingList createShoppingList(String listName, long userId) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setUser(userRepository.findOne(userId));
        shoppingList.setName(listName);
        return shoppingListRepository.save(shoppingList);
    }

    @Override
    public List<ShoppingList> getShoppingListsByUser(long userId) {
        User user = userRepository.findOne(userId);
        return shoppingListRepository.findByUser(user);
    }

    @Override
    public void removeShoppingList(long listId) {
        shoppingListRepository.delete(listId);
    }

    @Override
    public ShoppingList updateShoppingList(long listId, String listName) {
        return shoppingListRepository.updateShoppingList(listId, listName);
    }
}
