package com.eshop.shop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.eshop.shop.interfaces.RepositoryBase;
import com.eshop.shop.models.EntityBase;

public abstract class RepositoryBaseImplementation<TEntity extends EntityBase> implements RepositoryBase<TEntity> {

    private final List<TEntity> _entries;

    public RepositoryBaseImplementation() {
        _entries = new ArrayList<>();
    }

    @Override
    public List<TEntity> Get() {
        return _entries;
    }

    @Override
    public Optional<TEntity> GetById(long Id) {

        var entity = _entries.stream().filter(e -> e.getId().equals(Id)).findAny();
        return entity;
    }

    @Override
    public List<TEntity> Get(Predicate<? super TEntity> predicate) {

        var optional = _entries.stream().filter(predicate).toList();
        return optional;

    }

    @Override
    public boolean Add(TEntity entity) {
        return _entries.add(entity);
    }

    @Override
    public boolean Update(TEntity entity) {

        _entries.stream().filter(e -> e.getId().equals(entity.getId()))
                .findFirst()
                .ifPresent(e -> e = entity);
        return true;

    }

    @Override
    public boolean Remove(TEntity entity) {
        var finded = _entries.stream()
                .filter(e -> e.getId()
                .equals(entity.getId()))
                .findFirst().get();

        return _entries.removeIf(e -> e.getId().equals(finded.getId()));

    }

}
