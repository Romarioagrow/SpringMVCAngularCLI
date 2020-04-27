package app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Product {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    UUID productID;

    String productName, productType, productInfo;

    public Product(String productType, String productName) {

        this.productID = UUID.randomUUID();
        this.productType = productType;
        this.productName = productName;
    }
}
