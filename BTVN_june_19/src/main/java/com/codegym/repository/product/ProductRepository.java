package com.codegym.repository.product;

import com.codegym.model.Product;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class ProductRepository implements IProductRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select c from Product c", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findByID(Long id) {
        TypedQuery<Product> query = em.createQuery("select c from Product c where c.id=?1", Product.class);
        query.setParameter(1, id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Product product) {
        if (product.getId() != null){
            em.merge(product);
        } else {
            em.persist(product);
        }
    }

    @Override
    public void remove(Long id) {
        Product product = findByID(id);
        if (product != null){
            em.remove(product);
        }
    }
}
