package com.eshop.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.shop.models.Product;
import com.eshop.shop.repository.ProductRepository;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {


    @Autowired
    private ProductRepository _reporitory;

    @GetMapping("/")
    public List<Product> GetProducts(@RequestParam(value = "id", defaultValue = "") String identifier ) {

        List<Product> products = _reporitory.GetAll();
        return products;
  
    }
    
    public List<Product> GetAll(){

        return null;
    }

    @GetMapping("/Categories")
    public String GetCatrgories(@RequestParam String param) {
        return new String();
    }
    
    
}
