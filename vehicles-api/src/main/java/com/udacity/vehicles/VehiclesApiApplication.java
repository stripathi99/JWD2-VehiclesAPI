package com.udacity.vehicles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Launches a Spring Boot application for the Vehicles API, initializes the car manufacturers in the
 * database, and launches web clients to communicate with maps and pricing.
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
public class VehiclesApiApplication {

  private LoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction;

  public static void main(String[] args) {
    SpringApplication.run(VehiclesApiApplication.class, args);
  }

  @Autowired
  public void setLoadBalancerExchangeFilterFunction(
      LoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
    this.loadBalancerExchangeFilterFunction = loadBalancerExchangeFilterFunction;
  }

  /**
   * Initializes the car manufacturers available to the Vehicle API.
   *
   * @param repository where the manufacturer information persists.
   * @return the car manufacturers to add to the related repository
   */
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
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  /**
   * Web Client for the maps (location) API
   *
   * @param endpoint where to communicate for the maps API
   * @return created maps endpoint
   */
  @Bean(name = "maps")
  public WebClient webClientMaps(@Value("${maps.endpoint}") String endpoint) {
    return WebClient.create(endpoint);
  }

  /**
   * Web Client for the pricing API
   *
   * @param endpoint where to communicate for the pricing API
   * @return created pricing endpoint
   */
  @Bean(name = "pricing")
  public WebClient webClientPricing(@Value("${pricing.endpoint}") String endpoint) {
    // Implementation as per -> http://www.programmersought.com/article/5385639834
    return WebClient.builder().filter(loadBalancerExchangeFilterFunction).baseUrl(endpoint).build();
  }
}
