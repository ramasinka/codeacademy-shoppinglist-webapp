package lt.codeacademy.service.impl;

import lt.codeacademy.dao.ShareRepository;
import lt.codeacademy.model.ShareSummary;
import lt.codeacademy.model.ShoppingList;
import lt.codeacademy.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShareServiceImpl {

    @Resource
    private ShareRepository shareRepository;

    @Resource
    private ShareServiceImpl shareServiceImpl;

    @Resource
    private UserServiceImpl userServiceImpl;

    @Resource
    private ShoppingListServiceImpl shoppingListServiceImpl;

    @Resource
    private MailServiceImpl mailServiceImpl;

    public ShareSummary shareShoppingList(ShareSummary shareSummary) {
        String email = shareSummary.getEmail();
        if (userServiceImpl.userExistsByEmail(email)) {
            User toUser = userServiceImpl.findUserByEmail(email);
            if (!shareServiceImpl.isShoppingListShare(shareSummary)) {
                if (shoppingListServiceImpl.isShoppingListExists(shareSummary.getListId())) {
                    shareSummary.setToUserId(toUser.getId());
                    shareRepository.save(shareSummary);
                    ShoppingList shoppingList = shoppingListServiceImpl.findShoppingListById(shareSummary.getListId());
                    mailServiceImpl.sendMail(shoppingList.getName(), shareSummary, email);
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

    public void removeSharedList(long userId) {

    }
}
