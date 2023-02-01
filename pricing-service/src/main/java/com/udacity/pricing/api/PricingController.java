//package com.udacity.pricing.api;
//
//import static org.springframework.http.HttpStatus.NOT_FOUND;
//
//import com.udacity.pricing.domain.price.Price;
//import com.udacity.pricing.domain.price.PriceRepository;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
///**
// * Implements a REST-based controller for the pricing service.
// */
//@RestController
//@RequestMapping("/services/price")
//public class PricingController {
//
//
//  @Autowired
//  private PriceRepository priceRepository;
//
//  /**
//   * Gets the price for a requested vehicle.
//   *
//   * @param vehicleId ID number of the vehicle for which the price is requested
//   * @return price of the vehicle, or error that it was not found.
//   */
//  @GetMapping
//  public Price get(@RequestParam Long vehicleId) {
//    Optional<Price> priceOptional = priceRepository.findById(vehicleId);
//    if (priceOptional.isPresent()) {
//      return priceOptional.get();
//    } else {
//      throw new ResponseStatusException(NOT_FOUND, "Price Not Found");
//    }
//  }
//}
