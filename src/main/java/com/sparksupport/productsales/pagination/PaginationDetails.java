package com.sparksupport.productsales.pagination;

import lombok.Data;

@Data
public class PaginationDetails {
    private Boolean isLast;
    private Boolean isFirst;
    private Integer totalElements;
    private Integer totalPages;
    private Integer pageSize;
    private Integer pageNumber;

}
