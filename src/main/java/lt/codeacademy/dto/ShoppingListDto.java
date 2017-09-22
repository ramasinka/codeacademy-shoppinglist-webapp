package lt.codeacademy.dto;

public class ShoppingListDto {
    private long id;
    private String name;
    private long userId;

    public ShoppingListDto() {
    }

    public ShoppingListDto(String name, long userId) {
        this.name = name;
        this.userId = userId;
    }

    public ShoppingListDto(long id, String name, long userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
