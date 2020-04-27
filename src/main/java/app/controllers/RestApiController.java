package app.controllers;

import app.domain.Product;
import app.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {
    private final ProductService productService = new ProductService();

    @GetMapping("/products")
    public List<Product> sendAllProducts() {

        return productService.getAllProducts();
    }
}
