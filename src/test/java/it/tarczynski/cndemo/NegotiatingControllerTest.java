package it.tarczynski.cndemo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class NegotiatingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDifferentContentBasedOnAcceptHeader() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/strings")
        .accept("text/string.v1+plain"))
        .andExpect(status().isOk())
        .andExpect(content().string("I'm the V1 version"));

    mockMvc.perform(MockMvcRequestBuilders.get("/strings")
        .accept("text/string.v2+plain"))
        .andExpect(status().isOk())
        .andExpect(content().string("I'm the V2 version"));

  }

}
