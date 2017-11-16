package lt.codeacademy.controllers;

import lt.codeacademy.dao.ProductItemRepository;
import lt.codeacademy.dao.ShoppingListRepository;
import lt.codeacademy.dto.ProductItemDto;
import lt.codeacademy.model.ProductItem;
import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.dto_service.ProductItemDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductItemController {

    private static final String APPLICATION_JSON = "application/json";

    @Resource
    private ProductItemRepository productItemRepository;

    @Resource
    private ShoppingListRepository shoppingListRepository;

    @Resource
    private ProductItemDtoService productItemDtoService;

    @RequestMapping(value = "/getProductItem/{id}", method = RequestMethod.GET, consumes = APPLICATION_JSON,
            produces = APPLICATION_JSON)
    @ResponseBody
    public ProductItemDto getProductItem(@PathVariable long id) {
        ProductItem productItem = productItemRepository.findOne(id);
        ProductItemDto productItemDto = new ProductItemDto(productItem.getId(), productItem.getPprice(), productItem.getPamount(),
                productItem.getShoppingList().getId(), productItem.getPname());
        return productItemDto;
    }

    @RequestMapping(value = "/getProductItems/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public List<ProductItemDto> getProductItemsByShoppingList(@PathVariable long id) {
        ShoppingList shoppingList = shoppingListRepository.findOne(id);
        List<ProductItem> productItems = productItemRepository.findByShoppingList(shoppingList);
        return productItemDtoService.convertToProductItemDtoList(productItems);
    }

    @RequestMapping(value = "/createProductItem/{id}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ProductItemDto createProductItem(@RequestBody ProductItem productItem,
                                            @PathVariable long id) {
        ShoppingList shoppingList = shoppingListRepository.findOne(id);
        productItem.setShoppingList(shoppingList);
        productItemRepository.save(productItem);
        return new ProductItemDto(productItem.getId(), productItem.getPprice(), productItem.getPamount(),
                productItem.getShoppingList().getId(), productItem.getPname());
    }

    @RequestMapping(value = "/removeProductItem", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public void removeProductItem(@RequestParam("id") long id) {
        productItemRepository.delete(id);
    }


    @RequestMapping(value = "/updateProductItem/{id}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ProductItemDto updateProductItem(@RequestBody ProductItem productItem,
                                            @PathVariable long id) {
        String pname = productItem.getPname();
        int pamount = productItem.getPamount();
        int pprice = productItem.getPprice();
        productItemRepository.updateProductItem(id, pname, pamount, pprice);
        return new ProductItemDto(id, pname, pamount, pprice);
    }
}