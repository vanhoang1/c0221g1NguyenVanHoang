package com.blogspring.model.repository.blog;

import com.blogspring.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    @Query("select b from  Blog  b where b.title like %:title% ")
    Page<Blog> findAllByTitle(@Param("title")String title, Pageable pageable);
}
