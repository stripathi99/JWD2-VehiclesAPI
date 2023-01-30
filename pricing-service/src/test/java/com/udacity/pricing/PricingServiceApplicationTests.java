package com.udacity.pricing;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.udacity.pricing.api.PricingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingServiceApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void get_all_19_prices() throws Exception {
    for (int vehicleId = 1; vehicleId < 20; vehicleId++) {
      mockMvc.perform(get("/services/price?vehicleId=" + vehicleId))
          .andExpect(status().isOk())
          .andExpect(content().contentType(APPLICATION_JSON_UTF8))
          .andExpect(content().json("{}"))
          .andExpect(jsonPath("$.vehicleId").value(vehicleId));
    }
  }

  @Test
  public void test_for_invalid_id() throws Exception {
    mockMvc.perform(get("/services/price?vehicleId=20"))
        .andExpect(status().isNotFound());
  }
}
