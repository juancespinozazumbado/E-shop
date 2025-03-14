package com.eshop.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.shop.ShopApplication;
import com.eshop.shop.interfaces.ProductRepository;
import com.eshop.shop.models.Product;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ShopApplication shopApplication;

    @Autowired
    private ProductRepository _reporitory;

    ProductController(ShopApplication shopApplication) {
        this.shopApplication = shopApplication;
    }

    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public List<Product> GetAll(){

        return null;
    }

    @GetMapping("/Categories")
    public String GetCatrgories(@RequestParam String param) {
        return new String();
    }
    
    
}
