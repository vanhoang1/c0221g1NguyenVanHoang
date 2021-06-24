package com.product.model.repository;

import com.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value="Select * from Product where `name` like :keyword",nativeQuery= true)
    Page<Product> findAllByNameContaining(@Param("keyword") String keyword, Pageable pageable);

}
