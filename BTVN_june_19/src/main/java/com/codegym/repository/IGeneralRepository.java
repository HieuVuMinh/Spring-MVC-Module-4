package com.codegym.repository;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    T findByID(Long id);

    void save(T t);

    void remove(Long id);
}
