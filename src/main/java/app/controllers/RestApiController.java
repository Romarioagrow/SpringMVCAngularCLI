package app.controllers;

import app.domain.Product;
import app.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/api")
public class RestApiController {
  private final ProductService productService;

  @Autowired
  public RestApiController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  @CrossOrigin(origins = "http://localhost:4200")
  public Iterable<Product> sendAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/products/createList")
  @CrossOrigin(origins = "http://localhost:4200")
  public Iterable<Product> createProductList() {
    return productService.createProductList();
  }

  @GetMapping("/products/product/{productID}")
  @CrossOrigin(origins = "http://localhost:4200")
  public Product getProductData(@PathVariable Long productID) {
    return productService.getProduct(productID);
  }
}
