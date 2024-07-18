package com.example.rent_module.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CriteriaRepositoryImpl<T> implements CriteriaRepository<T> {

    private final EntityManager entityManager;

    @Override
    public T findByCriteria(Class<T> clazz, String value) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root)
                .where(criteriaBuilder.equal(root.get("login"), value));

        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<T> findAllCriteria(Class<T> clazz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

}
