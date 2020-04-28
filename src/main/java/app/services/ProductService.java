package app.services;

import app.domain.Product;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class ProductService {

  List<Product> products = createProductList();

  public List<Product> createProductList() {
    List<Product> products = new ArrayList<>();

    products.add(new Product((long) 1, "Телевизор", "Samsung T24H390SIX", 25500));
    products.add(new Product((long) 2,"Телевизор", "Lg 22MT58VF-PZ", 15200));
    products.add(new Product((long) 3,"Холодильник", "Indesit DS4160W", 13550));
    products.add(new Product((long) 4,"Холодильник", "Leran CBF177W", 27500));
    products.add(new Product((long) 5,"Стиральная машина", "Samsung T24H390SIX", 14560));
    products.add(new Product((long) 6,"Холодильник", "Бирюса 10", 21990));
    products.add(new Product((long) 7,"Утюг", "Bosch TDA 2377", 2590));
    products.add(new Product((long) 8,"Магнитола", "Sony ZS-PS50B", 1590));
    products.add(new Product((long) 9,"Кухонная плита", "Darina 1BKM441301W", 7800));
    products.add(new Product((long) 10,"Блинница", "Gfgril GFC-B200 PERFECT", 3500));
    products.add(new Product((long) 11,"Музыкальный центр", "LG OM7550K", 4290));

    return products;
  }

  public List<Product> getAllProducts() {
    return this.products;
  }

  public Product getProductData(String productID) {
    for (Product product : products) {
      if (product.getProductID().toString().equals(productID)) {
        log.info(product.toString());
        return product;
      }
    }
    return null;
  }
}
