package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface ICommentService {

    public List<Comment> findAll();

    public Comment findOne(Long id);

    public Comment save(Comment customer);
}
