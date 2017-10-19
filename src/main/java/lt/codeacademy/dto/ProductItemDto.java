package lt.codeacademy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductItemDto {
    private long id;
    private String name;
    private long amount;
    private long price;
    private long listId;

    public ProductItemDto(long id, long price, long amount, long listId, String name) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.listId = listId;
        this.name = name;
    }

    public ProductItemDto(long id, String name, long amount, long price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
}
