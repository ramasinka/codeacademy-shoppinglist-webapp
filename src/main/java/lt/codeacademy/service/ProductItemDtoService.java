package lt.codeacademy.service;

import lt.codeacademy.dto.ProductItemDto;
import lt.codeacademy.model.ProductItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductItemDtoService {

    public List<ProductItemDto> convertToProductItemDtoList(List<ProductItem> productItems) {
        List<ProductItemDto> productItemDtos = new ArrayList<>();
        for (ProductItem p : productItems) {
            ProductItemDto productItemDto = new ProductItemDto(p.getId(), p.getPprice(),
                    p.getPamount(), p.getShoppingList().getId(), p.getPname());
            productItemDtos.add(productItemDto);
        }
        return productItemDtos;
    }
}
