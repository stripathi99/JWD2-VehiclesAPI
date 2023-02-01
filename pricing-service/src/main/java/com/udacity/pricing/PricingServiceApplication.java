package com.udacity.pricing;

import static java.math.RoundingMode.HALF_UP;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Creates a Spring Boot Application to run the Pricing Service - REST API.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PricingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(PricingServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner initDatabase(PriceRepository priceRepository) {
    return args -> {
      LongStream.range(0, 20).forEach(i -> {
        priceRepository.save(new Price("USD", randomPrice(), i));
      });
    };
  }

  private static BigDecimal randomPrice() {
    return BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1, 5))
        .multiply(new BigDecimal("5000")).setScale(2, HALF_UP);
  }

//    @Bean
//    CommandLineRunner initDatabase(ManufacturerRepository repository) {
//        return args -> {
//            repository.save(new Manufacturer(100, "Audi"));
//            repository.save(new Manufacturer(101, "Chevrolet"));
//            repository.save(new Manufacturer(102, "Ford"));
//            repository.save(new Manufacturer(103, "BMW"));
//            repository.save(new Manufacturer(104, "Dodge"));
//        };
//    }
}
