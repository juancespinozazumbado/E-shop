package com.eshop.shop.repository;

import org.springframework.stereotype.Service;

import com.eshop.shop.interfaces.ProductRepository;
import com.eshop.shop.models.Product;

@Service
public class ProductRepositoryImplementation extends RepositoryBaseImplementation<Product> implements ProductRepository{
    
}
