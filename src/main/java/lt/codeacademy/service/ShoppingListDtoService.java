package lt.codeacademy.service;

import lt.codeacademy.dto.ShoppingListDto;
import lt.codeacademy.model.ShoppingList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListDtoService {
    public List<ShoppingListDto> convertToShoppingListDtoList(List<ShoppingList> shoppingLists) {
        List<ShoppingListDto> shoppingListDtos = new ArrayList<>();
        for (ShoppingList shop : shoppingLists) {
            ShoppingListDto shoppingListDto = new ShoppingListDto(shop.getId(), shop.getName(), shop.getUser().getId());
            shoppingListDtos.add(shoppingListDto);
        }
        return shoppingListDtos;
    }
}
