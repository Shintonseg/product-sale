package com.sparksupport.productsales.service;

import com.sparksupport.productsales.model.Product;
import com.sparksupport.productsales.pagination.PaginationData;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    PaginationData getAllProduct(Pageable pageable);
    Optional<Product> getProductById(int id);
    Product addProduct(Product product);
    Product updateProduct(int id,Product product);
    void deleteProduct(int id);
    void getTotalRevenue();
    void getRevenueByProduct(int productId);


}
