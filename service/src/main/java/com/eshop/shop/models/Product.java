package com.eshop.shop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Product extends EntityBase {

    private String Name;
    private String Description;
    private long CategoryId;
    private boolean isInStok = false;
}
