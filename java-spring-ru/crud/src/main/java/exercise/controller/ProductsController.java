package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import jakarta.validation.Valid;

@RestController
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    List<ProductDTO> index() {
        var posts = productRepository.findAll();
        var result = posts.stream()
                .map(productMapper::map)
                .toList();

        return result;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    ProductDTO create(@Valid @RequestBody ProductCreateDTO postData) {
        var category = categoryRepository.findById(postData.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category with " + postData.getCategoryId() + " not found"));
        var product = productMapper.map(postData);
        product.setCategory(category);
        productRepository.save(product);
        var postDTO = productMapper.map(product);
        return postDTO;
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductDTO show(@PathVariable Long id) {
        var post = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var postDTO = productMapper.map(post);
        return postDTO;
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductDTO update(@RequestBody @Valid ProductUpdateDTO postData, @PathVariable Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var category = categoryRepository.findById(postData.getCategoryId().get())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        productMapper.update(postData, product);
        product.setCategory(category);
        productRepository.save(product);
        var postDTO = productMapper.map(product);
        return postDTO;
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    // END
}
