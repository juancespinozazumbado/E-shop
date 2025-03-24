package com.eshop.shop.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Catrgory extends  EntityBase {

    public String Name; 
    public String Description; 
    public List<Product> Produsts; 
    
}
