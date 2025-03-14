package com.eshop.shop.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public abstract class EntityBase {

    private Long Id;
    private Date CreatedDate;

    public EntityBase(){
        
        this.Id = Long.parseLong("10000"+ Math.random() * ((100 - 1) + 1));
        this.CreatedDate = new Date();

    }

}
