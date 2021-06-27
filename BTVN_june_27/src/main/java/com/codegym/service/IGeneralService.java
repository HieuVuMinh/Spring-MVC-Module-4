package com.codegym.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    Iterable<T> findAll();

    Optional<T> findAllById(Long id);

    T save(T t);

    void delete(Long id);
}
