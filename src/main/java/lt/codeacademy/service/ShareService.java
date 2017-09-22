package lt.codeacademy.service;

import lt.codeacademy.dao.ShareRepository;
import lt.codeacademy.model.ShareSummary;
import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShareService {

    @Resource
    private ShareRepository shareRepository;

    @Resource
    private ShareService shareService;

    @Resource
    private UserService userService;

    @Resource
    private ShoppingListService shoppingListService;

    @Resource
    private MailService mailService;

    public ShareSummary shareShoppingList(ShareSummary shareSummary) {
        String email = shareSummary.getEmail();
        if (userService.userExistsByEmail(email)) {
            User toUser = userService.findUserByEmail(email);
            if (!shareService.isShoppingListShare(shareSummary)) {
                if (shoppingListService.isShoppingListExists(shareSummary.getListId())) {
                    shareSummary.setToUserId(toUser.getId());
                    shareRepository.save(shareSummary);
                    ShoppingList shoppingList = shoppingListService.findShoppingListById(shareSummary.getListId());
                    mailService.sendMail(shoppingList.getName(), shareSummary, email);
                }
            }
        }
        return shareSummary;
    }

    private boolean isShoppingListShare(ShareSummary shareSummary) {
        ShareSummary result = shareRepository.findByEmailAndListId(shareSummary.getEmail(), shareSummary.getListId());
        if (result != null) {
            throw new RuntimeException("Shopping list was shared");
        }
        return false;
    }

    public void confirmShare(ShareSummary shareSummary) {
        shareSummary.setStatus("Confirmed");
        shareRepository.update(shareSummary.getId(), shareSummary.getStatus());
    }

    public List<ShoppingList> findSharedShoppingLists(long userId) {
        return shareRepository.findSharedShoppingLists(userId);
    }
}
