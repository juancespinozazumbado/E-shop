package com.eshop.shop.repository;

import org.springframework.stereotype.Service;

import com.eshop.shop.interfaces.RepositoryBase;
import com.eshop.shop.models.Product;

@Service
public interface ProductRepository extends RepositoryBase<Product> {

    
}
