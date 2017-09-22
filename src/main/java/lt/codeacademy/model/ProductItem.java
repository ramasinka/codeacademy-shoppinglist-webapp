package lt.codeacademy.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String pname;
    private int pamount;
    private int pprice;

    @ManyToOne
    @JoinColumn(name = "shoppinglist_id")
    private ShoppingList shoppingList;

    public ProductItem() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPamount() {
        return pamount;
    }

    public void setPamount(int pamount) {
        this.pamount = pamount;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
