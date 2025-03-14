package com.eshop.shop.interfaces;

import java.util.List;
import java.util.Optional;

import com.eshop.shop.models.EntityBase;

public interface RepositoryBase<TEntity extends EntityBase>  {

    public boolean AddProduct(TEntity product); 
    public boolean UpdateProduct(TEntity product);
    public boolean DeleteProduct(TEntity product);

    public List<TEntity> GetAll();
    public Optional<TEntity> GetById(long id);
}
