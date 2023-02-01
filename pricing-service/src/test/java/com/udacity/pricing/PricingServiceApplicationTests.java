package com.udacity.pricing;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void get_all_19_prices() throws Exception {
    for (int i = 1; i < 20; i++) {
      mockMvc.perform(get("/prices/" + i))
          .andExpect(status().isOk())
          .andExpect(content().contentType(HAL_JSON_UTF8))
          .andExpect(content().json("{}"));
    }
  }

  @Test
  public void test_for_invalid_id() throws Exception {
    mockMvc.perform(get("/prices/20"))
        .andExpect(status().isNotFound());
  }
}
