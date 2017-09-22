package lt.codeacademy.dto;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
