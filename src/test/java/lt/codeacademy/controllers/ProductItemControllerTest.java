package lt.codeacademy.controllers;

import lt.codeacademy.dao.ProductItemRepository;
import lt.codeacademy.model.ProductItem;
import lt.codeacademy.model.ShoppingList;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductItemControllerTest {
    @Mock
    private ProductItemRepository productItemRepository;

    @Test
    public void getProductItem() throws Exception {
        ProductItem productItem = new ProductItem();
        productItem.setShoppingList(new ShoppingList());
        productItem.setPamount(12);
        productItem.setId(1);
        productItem.setPname("Test");
        productItem.setPprice(12);
        productItemRepository.save(productItem);
        when(productItemRepository.save(productItem)).thenReturn(productItem);

        
//        assertEquals(productItem, productItemRepository.findOne(1L));
    }

    @Test
    public void getProductItemsByShoppingList() throws Exception {
    }

    @Test
    public void createProductItem() throws Exception {
    }

    @Test
    public void removeProductItem() throws Exception {
    }

    @Test
    public void updateProductItem() throws Exception {
    }

}