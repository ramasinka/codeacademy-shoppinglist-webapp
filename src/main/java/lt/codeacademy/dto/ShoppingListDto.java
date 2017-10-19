package lt.codeacademy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingListDto {
    private long id;
    private String name;
    private long userId;

    public ShoppingListDto(String name, long userId) {
        this.name = name;
        this.userId = userId;
    }

    public ShoppingListDto(long id, String name, long userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }
}
