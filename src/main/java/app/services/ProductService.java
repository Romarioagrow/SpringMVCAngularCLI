package app.services;

import app.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Телевизор", "Samsung T24H390SIX"));
        products.add(new Product("Телевизор", "Lg 22MT58VF-PZ"));
        products.add(new Product("Холодильник", "Indesit DS4160W"));
        products.add(new Product("Холодильник", "Leran CBF177W"));
        products.add(new Product("Стиральная машина", "Samsung T24H390SIX"));
        products.add(new Product("Холодильник", "Бирюса 10"));
        products.add(new Product("Утюг", "Bosch TDA 2377"));
        products.add(new Product("Магнитола", "Sony ZS-PS50B"));
        products.add(new Product("Кухонная плита", "Darina 1BKM441301W"));
        products.add(new Product("Блинница", "Gfgril GFC-B200 PERFECT"));
        products.add(new Product("Музыкальный центр", "LG OM7550K"));

        return products;
    }
}
