package app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="products")
@NoArgsConstructor
public class Product {
  @Id
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
