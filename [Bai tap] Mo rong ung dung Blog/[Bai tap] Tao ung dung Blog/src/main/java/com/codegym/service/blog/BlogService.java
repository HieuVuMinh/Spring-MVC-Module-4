package com.codegym.service.blog;

import com.codegym.model.BlogWeb;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<BlogWeb> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<BlogWeb> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public BlogWeb save(BlogWeb blogWeb) {
       return blogRepository.save(blogWeb);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
