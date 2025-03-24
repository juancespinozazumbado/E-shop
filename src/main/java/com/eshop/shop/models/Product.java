package com.eshop.shop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product extends EntityBase {

    private String Name;
    public String Description;
    public long CategoryId;
    public boolean isInStok = false;

    public Product(String name, String description){

        name = name; 
        Description = description;
        // CategoryId = 0L;
    }
}
