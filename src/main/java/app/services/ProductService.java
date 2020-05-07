package app.services;

import app.domain.Product;
import app.domain.User;
import app.domain.roles.Role;
import app.repos.ProductRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log
@Service("productService")
@Transactional
public class ProductService {
  private final ProductRepo productRepo;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public ProductService(ProductRepo productRepo, PasswordEncoder passwordEncoder) {
    this.productRepo = productRepo;
    this.passwordEncoder = passwordEncoder;
  }

  public void save(Product product) {
    productRepo.save(product);
  }

  public List<Product> listAll() {
    return (List<Product>) productRepo.findAll();
  }

  public Product get(Long id) {
    return productRepo.findById(id).get();
  }

  public void delete(Long id) {
    productRepo.deleteById(id);
  }

  public Iterable<Product> createProductList() {
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

    productRepo.saveAll(products);
    productRepo.findAll().forEach(product -> log.info(product.getProductName()));
    return productRepo.findAll();
  }

  public Iterable<Product> getAllProducts() {
    return productRepo.findAll();
  }

  public Product getProduct(Long productID) {
    return productRepo.findByProductID(productID);
  }

}
