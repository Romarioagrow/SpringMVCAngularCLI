package app.controllers;

import app.domain.Product;
import app.services.ProductService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/api")
public class RestApiController {
  private final ProductService productService = new ProductService();

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/products")
  public List<Product> sendAllProducts() {
    log.info("REST GetMapping");
    return productService.getAllProducts();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/products/product/{productID}")
  public Product getProductData(@PathVariable String productID) {
    log.info("productID: " + productID);
    return productService.getProductData(productID);
  }
}
