package com.eshop.shop.repository;

import org.springframework.stereotype.Service;

import com.eshop.shop.interfaces.CategoryRepository;
import com.eshop.shop.models.Catrgory;

@Service
public class CategoryRepositoryImplementation extends RepositoryBaseImplementation<Catrgory> implements  CategoryRepository{
    
}
