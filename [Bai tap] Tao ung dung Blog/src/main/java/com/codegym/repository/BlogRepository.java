package com.codegym.repository;

import com.codegym.model.BlogWeb;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BlogWeb> findAll() {
        TypedQuery<BlogWeb> query = em.createQuery("select c from BlogWeb c", BlogWeb.class);
        return query.getResultList();
    }

    @Override
    public BlogWeb findById(Long id) {
        TypedQuery<BlogWeb> query = em.createQuery("select c from BlogWeb c where c.id= ?1", BlogWeb.class);
        query.setParameter(1, id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(BlogWeb blogWeb) {
        if (blogWeb != null){
            em.merge(blogWeb);
        } else {
            em.persist(blogWeb);
        }
    }

    @Override
    public void remove(Long id) {
        BlogWeb blogWeb = findById(id);
        if (blogWeb != null){
            em.remove(blogWeb);
        }
    }
}
