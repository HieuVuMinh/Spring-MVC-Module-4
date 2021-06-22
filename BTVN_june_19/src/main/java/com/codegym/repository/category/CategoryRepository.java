package com.codegym.repository.category;

import com.codegym.model.Category;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class CategoryRepository implements ICategoryRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> query = em.createQuery("select c from Category c", Category.class);
        return query.getResultList();
    }

    @Override
    public Category findByID(Long id) {
        TypedQuery<Category> query = em.createQuery("select c from Category c where c.categoryId = ?1", Category.class);
        query.setParameter(1, id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Category category) {
        if (category.getCategoryId() != null){
            em.merge(category);
        } else {
            em.persist(category);
        }
    }

    @Override
    public void remove(Long id) {
        Category category = findByID(id);
        if (category != null){
            em.remove(category);
        }
    }
}
