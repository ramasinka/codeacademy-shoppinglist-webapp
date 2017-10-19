package lt.codeacademy.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

}

