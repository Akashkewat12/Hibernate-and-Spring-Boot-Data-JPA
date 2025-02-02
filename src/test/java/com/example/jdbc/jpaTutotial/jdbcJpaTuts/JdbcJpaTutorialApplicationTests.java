package com.example.jdbc.jpaTutotial.jdbcJpaTuts;

import com.example.jdbc.jpaTutotial.jdbcJpaTuts.entities.ProductEntity;
import com.example.jdbc.jpaTutotial.jdbcJpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JdbcJpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testRepository() {
//		ProductEntity productEntity= ProductEntity.builder()
//				.sku("nestle234")
//				.title("Nestle chocolate")
//				.price(BigDecimal.valueOf(123.45))
//				.quantity(12)
//				.build();
//		ProductEntity savedProductEntity=productRepository.save(productEntity);
//		System.out.println(savedProductEntity);
//	}

	@Test
	void getRepository() {
		List<ProductEntity> entities=productRepository.findAll();
		System.out.println(entities);
	}
}
