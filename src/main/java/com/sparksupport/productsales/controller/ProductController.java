package com.sparksupport.productsales.controller;

import com.sparksupport.productsales.model.Product;
import com.sparksupport.productsales.pagination.PaginationData;
import com.sparksupport.productsales.response.ResponseHandler;
import com.sparksupport.productsales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/search")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Object> getAllProduct(Pageable pageable){
        PaginationData object = productService.getAllProduct(pageable);
        return ResponseHandler.responseMessage("product list",HttpStatus.OK,object);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("product deleted", HttpStatus.OK);
    }
}
