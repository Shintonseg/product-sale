package com.sparksupport.productsales.service;

import com.sparksupport.productsales.exception.ProductNotFoundException;
import com.sparksupport.productsales.model.Product;
import com.sparksupport.productsales.pagination.PaginationData;
import com.sparksupport.productsales.pagination.PaginationDetails;
import com.sparksupport.productsales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public PaginationData getAllProduct(Pageable pageable){
        PaginationData paginationData = new PaginationData();
        Page<Product> pageResponse = productRepository.findAll(pageable);
        paginationData.setProductList(pageResponse.getContent());
        paginationData.setPaginationDetails(setRequiredPageField(pageResponse));
        return paginationData;
    }

    private PaginationDetails setRequiredPageField(Page<Product> pageResponse) {
        PaginationDetails paginationDetails = new PaginationDetails();
        paginationDetails.setIsFirst(pageResponse.isFirst());
        paginationDetails.setIsLast(pageResponse.isLast());
        paginationDetails.setTotalElements(pageResponse.getNumberOfElements());
        paginationDetails.setPageNumber(pageResponse.getNumber());
        paginationDetails.setTotalPages(pageResponse.getTotalPages());
        return paginationDetails;
    }

    public Optional<Product> getProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("product with given id not found");
        }
        return productRepository.findById(id);
    }

    public Product addProduct(Product product){
       return productRepository.save(product);
    }

    public Product updateProduct(int id,Product product){
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public void getTotalRevenue() {

    }

    public void getRevenueByProduct(int productId) {

    }
}
