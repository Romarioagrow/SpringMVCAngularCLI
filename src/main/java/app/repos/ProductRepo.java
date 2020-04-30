package app.repos;

import app.domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("productRepo")
public interface ProductRepo extends CrudRepository<Product, Long> {

  Product findByProductID(Long productID);

}
