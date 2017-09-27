package lt.codeacademy.controllers;

import lt.codeacademy.dao.ShareRepository;
import lt.codeacademy.dto.ShoppingListDto;
import lt.codeacademy.model.ShareSummary;
import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.service.ShareService;
import lt.codeacademy.service.ShoppingListDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class ShareController {

    public static final String APPLICATION_JSON = "application/json";

    @Resource
    private ShareService shareService;

    @Resource
    private ShareRepository shareRepository;

    @Resource
    private ShoppingListDtoService shoppingListDtoService;

    @RequestMapping(value = "/shareShoppingList", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public ShareSummary shareShoppingList(@RequestBody ShareSummary shareSummary) {
        shareSummary.setDate(new Date());
        shareSummary.setStatus("notConfirmed");
        shareService.shareShoppingList(shareSummary);
        return shareSummary;
    }

    @RequestMapping(value = "/shareShoppingList/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ShareSummary getShareSummaryById(@PathVariable long id) {
        return shareRepository.findOne(id);
    }

    @RequestMapping(value = "/confirmationShare/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public ShareSummary confirmShare(@PathVariable long id) {
        ShareSummary shareSummary = shareRepository.findOne(id);
        shareService.confirmShare(shareSummary);
        return shareSummary;
    }

    @RequestMapping(value = "/getSharedList/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseBody
    public List<ShoppingListDto> getSharedLists(@PathVariable long userId) {
        List<ShoppingList> sharedShoppingLists = shareService.findSharedShoppingLists(userId);
        return shoppingListDtoService.convertToShoppingListDtoList(sharedShoppingLists);
    }

  /*  @RequestMapping(value = "/removeSharedList/{userId}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseBody
    public void removeSharedList(@PathVariable long userId) {
        shareService.removeSharedList(userId);
        return shoppingListDtoService.convertToShoppingListDtoList(sharedShoppingLists);
    }*/

}