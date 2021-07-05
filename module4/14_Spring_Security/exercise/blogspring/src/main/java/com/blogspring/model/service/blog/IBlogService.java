package com.blogspring.model.service.blog;

import com.blogspring.model.entity.Blog;
import com.blogspring.model.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitle(String title, Pageable pageable);
    Iterable<Blog> findAllByCategoryId(Long id);
}
