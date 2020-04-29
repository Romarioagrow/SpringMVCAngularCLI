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

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/products")
  public Iterable<Product> sendAllProducts() {
    log.info("REST GetMapping");
    return productService.getAllProducts();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/products/product/{productID}")
  public Product getProductData(@PathVariable Long productID) {
    log.info("productID: " + productID);
    return productService.getProduct(productID);
  }
}
