package com.sparksupport.productsales.pagination;

import com.sparksupport.productsales.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class PaginationData {
    private List<Product> productList;
    private PaginationDetails paginationDetails;
}
