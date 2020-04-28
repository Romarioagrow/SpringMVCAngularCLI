package app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID productID;*/

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
