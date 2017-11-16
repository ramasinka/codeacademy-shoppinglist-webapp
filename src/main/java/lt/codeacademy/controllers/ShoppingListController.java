package lt.codeacademy.controllers;

import lt.codeacademy.dao.ShoppingListRepository;
import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.dto.ShoppingListDto;
import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.model.User;
import lt.codeacademy.dto_service.ShoppingListDtoService;
import lt.codeacademy.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ComponentScan({"lt.codeacademy.dao"})
public class ShoppingListController {

    private static final String APPLICATION_JSON = "application/json";

    @Resource
    private ShoppingListService shoppingListService;

    @Resource
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Resource
    private ShoppingListDtoService shoppingListDtoService;


    @RequestMapping(value = "/getShoppingLists", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public List<ShoppingListDto> getAllShoppingLists() {
        List<ShoppingList> shoppingLists = (List<ShoppingList>) shoppingListService.getAllShoppingLists();
        return shoppingListDtoService.convertToShoppingListDtoList(shoppingLists);
    }

    @RequestMapping(value = "/getShoppingList/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ShoppingListDto getShoppingList(@PathVariable long id) {
        ShoppingList shoppingList = shoppingListService.getShoppingList(id);
        ShoppingListDto shoppingListDto = new ShoppingListDto(shoppingList.getName(), shoppingList.getUser().getId());
        return shoppingListDto;
    }

    @RequestMapping(value = "/createShoppingList", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ShoppingList createShoppingList(@RequestParam("listName") String listName,
                                           @RequestParam("userId") long userId) {
        return shoppingListService.createShoppingList(listName, userId);
    }

    @RequestMapping(value = "/getShoppingLists/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public List<ShoppingListDto> getShoppingListsByUser(@PathVariable("userId") long userId) {
        List<ShoppingList> shoppingLists = shoppingListService.getShoppingListsByUser(userId);
        return shoppingListDtoService.convertToShoppingListDtoList(shoppingLists);
    }

    @RequestMapping(value = "/removeShoppingList", method = RequestMethod.POST, produces = APPLICATION_JSON)
    public void removeShoppingList(@RequestParam("listId") long listId) {
        shoppingListService.removeShoppingList(listId);
    }

    @RequestMapping(value = "/updateShoppingList", method = RequestMethod.POST, produces = APPLICATION_JSON)
    public ShoppingList updateShoppingList(@RequestParam("listId") Long listId, @RequestParam("listName") String listName) {
        return shoppingListService.updateShoppingList(listId, listName);
    }
}
