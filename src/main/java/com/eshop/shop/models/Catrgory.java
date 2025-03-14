package com.eshop.shop.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Catrgory {

    private long Id; 
    private String Name; 
    private String Description; 
    private List<Product> Produsts; 
    
}
