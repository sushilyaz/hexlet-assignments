package exercise.controller;

import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.*;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    public List<Product> index(@RequestParam(required = false) Integer min,
                               @RequestParam(required = false) Integer max) {
        if (min == null && max == null) {
            return productRepository.findAllByOrderByPriceAsc();
        } else if (min != null && max == null) {
            return productRepository.findAllByPriceAfter(Sort.by(Sort.Order.asc("price")), min);
        } else if (min == null && max != null) {
            return productRepository.findAllByPriceBefore(Sort.by(Sort.Order.asc("price")), max);
        } else {
            return productRepository.findAllByPriceBetween(Sort.by(Sort.Order.asc("price")), min, max);
        }
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
