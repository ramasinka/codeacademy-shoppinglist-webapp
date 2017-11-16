package lt.codeacademy.service;

import lt.codeacademy.model.ShoppingList;

import java.util.List;

public interface ShoppingListService {

    Iterable<ShoppingList> getAllShoppingLists();

    ShoppingList getShoppingList(long id);

    ShoppingList createShoppingList(String listName, long userId);

    List<ShoppingList> getShoppingListsByUser(long userId);

    void removeShoppingList(long listId);

    ShoppingList updateShoppingList(long listId, String listName);
}
