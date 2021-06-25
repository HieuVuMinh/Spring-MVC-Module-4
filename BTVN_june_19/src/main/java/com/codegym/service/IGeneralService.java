package com.codegym.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findByID(Long id);

    void save(T t);

    void remove(Long id);
}
