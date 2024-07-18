package com.example.rent_module.repository;

import java.util.List;

public interface CriteriaRepository<T> {

    T findByCriteria(Class<T> clazz, String value);

    List<T> findAllCriteria(Class<T> clazz);
}
