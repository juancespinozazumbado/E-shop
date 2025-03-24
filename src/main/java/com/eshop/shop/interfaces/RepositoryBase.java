package com.eshop.shop.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.eshop.shop.models.EntityBase;

public interface RepositoryBase<TEntity extends EntityBase> {


    public boolean Add(TEntity product);

    public boolean Update(TEntity product);

    public boolean Remove(TEntity product);

       /**
     * Gets a list of entities in the repository
     *
     * @return A list of matching entities.
     */
    public List<TEntity> Get();

    public Optional<TEntity> GetById(long id);

    /**
     * Gets a list of entities that match the given predicate.
     *
     * @param predicate<T>  The condition to filter entities.
     * @return A list of matching entities.
     */
  
    public List<TEntity> Get(Predicate<? super TEntity> predicate);
}
