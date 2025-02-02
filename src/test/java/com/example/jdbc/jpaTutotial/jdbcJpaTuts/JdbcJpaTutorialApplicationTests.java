package com.example.jdbc.jpaTutotial.jdbcJpaTuts;

import com.example.jdbc.jpaTutotial.jdbcJpaTuts.entities.ProductEntity;
import com.example.jdbc.jpaTutotial.jdbcJpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JdbcJpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity= ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity=productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {
//		List<ProductEntity> entities=productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2024,10,2,0,0,0)
//		);
//		List<ProductEntity> entities=productRepository.findByQuantityGreaterThanAndPriceLessThan(4, BigDecimal.valueOf(23.45));

//		List<ProductEntity> entities=productRepository.findByTitleLike("%cho%");
		List<ProductEntity> entities=productRepository.findByTitleContainingIgnoreCase("choco");
		System.out.println(entities);
	}

	@Test
    void getSingleFromRepository() {
		Optional<ProductEntity> productEntity=productRepository
				.findByTitleAndPrice("Nestle chocolate",BigDecimal.valueOf(23.45));
		productEntity.ifPresent(System.out::println);

	}
}
