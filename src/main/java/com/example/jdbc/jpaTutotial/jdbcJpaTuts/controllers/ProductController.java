package com.example.jdbc.jpaTutotial.jdbcJpaTuts.controllers;


import com.example.jdbc.jpaTutotial.jdbcJpaTuts.entities.ProductEntity;
import com.example.jdbc.jpaTutotial.jdbcJpaTuts.repositories.ProductRepository;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE=5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pagenumber) {


        return productRepository.findByTitleContainingIgnoreCase(title,
                PageRequest.of(pagenumber, PAGE_SIZE, Sort.by(sortBy)
                ));
    }
        //        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy,"price","quantity"));
//    return productRepository.findBy(Sort.by(
//            Sort.Order.desc(sortBy),
//            Sort.Order.desc("title")  // we can add more sorting field
//

//        Pageable pageable= PageRequest.of(
//                pagenumber,
//                PAGE_SIZE,
//                Sort.by(sortBy)
//        );
//        return productRepository.findAll(pageable).getContent();


}
