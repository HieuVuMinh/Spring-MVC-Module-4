package com.codegym.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategory;
    private String nameCategory;

    @OneToMany(targetEntity = BlogWeb.class)
    private List<BlogWeb> blogWebs;

    public Category() {
    }

    public Category(Long idCategory, String nameCategory, List<BlogWeb> blogWebs) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.blogWebs = blogWebs;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<BlogWeb> getBlogWebs() {
        return blogWebs;
    }

    public void setBlogWebs(List<BlogWeb> blogWebs) {
        this.blogWebs = blogWebs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(idCategory, category.idCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory);
    }
}
