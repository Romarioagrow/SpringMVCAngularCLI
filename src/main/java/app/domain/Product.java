package app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Product {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    //UUID productID;
    //UUID productID;

    Long productID;

    String productName, productType, productInfo;

    Integer productPrice;

    public Product(Long productID, String productType, String productName, Integer productPrice) {
        this.productID = productID;
        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;

    }

}
