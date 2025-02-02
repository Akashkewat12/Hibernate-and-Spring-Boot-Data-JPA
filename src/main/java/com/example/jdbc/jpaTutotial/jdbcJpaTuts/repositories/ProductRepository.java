package com.example.jdbc.jpaTutotial.jdbcJpaTuts.repositories;

import com.example.jdbc.jpaTutotial.jdbcJpaTuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


}
