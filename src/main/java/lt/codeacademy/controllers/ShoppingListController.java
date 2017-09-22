package lt.codeacademy.controllers;

import lt.codeacademy.dao.ShoppingListRepository;
import lt.codeacademy.dao.UserRepository;
import lt.codeacademy.dto.ShoppingListDto;
import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.model.User;
import lt.codeacademy.service.ShoppingListDtoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ComponentScan({"lt.codeacademy.dao"})
public class ShoppingListController {

    public static final String APPLICATION_JSON = "application/json";
    @Resource
    @Qualifier("shoppingListRepository")
    private ShoppingListRepository shoppingListRepository;

    @Resource
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Resource
    private ShoppingListDtoService shoppingListDtoService;

    @RequestMapping(value = "/getShoppingList/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ShoppingListDto getShoppingList(@PathVariable long id) {
        ShoppingList shoppingList = shoppingListRepository.findOne(id);
        ShoppingListDto shoppingListDto = new ShoppingListDto(shoppingList.getName(), shoppingList.getUser().getId());
        return shoppingListDto;
    }

    @RequestMapping(value = "/createShoppingList", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ShoppingList createShoppingList(@RequestParam("listName") String listName,
                                           @RequestParam("userId") long userId) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setUser(userRepository.findOne(userId));
        shoppingList.setName(listName);
        shoppingListRepository.save(shoppingList);
        return shoppingList;
    }

    @RequestMapping(value = "/getShoppingLists/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public List<ShoppingListDto> getShoppingListsByUser(@PathVariable("userId") long userId) {
        User user = userRepository.findOne(userId);
        List<ShoppingList> shoppingLists = shoppingListRepository.findByUser(user);
        return shoppingListDtoService.convertToShoppingListDtoList(shoppingLists);
    }

    @RequestMapping(value = "/removeShoppingList", method = RequestMethod.POST, produces = APPLICATION_JSON)
    public void removeShoppingList(@RequestParam("listId") long listId) {
        shoppingListRepository.delete(listId);
    }

    @RequestMapping(value = "/updateShoppingList", method = RequestMethod.POST, produces = APPLICATION_JSON)
    public void updateShoppingList(@RequestParam("listId") Long listId, @RequestParam("listName") String listName) {
        shoppingListRepository.updateShoppingList(listId, listName);
    }
}
