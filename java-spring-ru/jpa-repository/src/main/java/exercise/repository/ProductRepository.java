package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByPriceAfter(Sort sort, int min);
    List<Product> findAllByPriceBefore(Sort sort, int max);
    List<Product> findAllByPriceBetween(Sort sort, int min, int max);

    // END
}
