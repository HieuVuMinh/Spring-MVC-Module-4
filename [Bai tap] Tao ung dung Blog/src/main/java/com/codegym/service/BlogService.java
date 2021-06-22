package com.codegym.service;

import com.codegym.model.BlogWeb;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<BlogWeb> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public BlogWeb findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(BlogWeb blogWeb) {
        blogRepository.save(blogWeb);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
