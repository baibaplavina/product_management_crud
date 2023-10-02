package com.example.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteById(Long id);



    Optional<Product> findById(Long id);
    List<Product> findByName(String name);

    @Query(value = "select * from product p where p.name like %:keyword% or p.category like %:keyword%", nativeQuery = true)
    List<Product> findByKeyword(@Param("keyword") String keyword);


}
