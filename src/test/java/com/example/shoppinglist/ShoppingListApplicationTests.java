package com.example.shoppinglist;

import com.example.shoppinglist.controllers.RESTApiController;
import com.example.shoppinglist.models.Product;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
class ShoppingListApplicationTests {
    @Autowired
    private RESTApiController restApiController;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void rest() throws Exception{
        assertThat(restApiController).isNotNull();
    }

    @Test
    public void listOfProducts() throws Exception {
        this.mockMvc.perform(get("/api/products/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getProductById() throws Exception {
        long id = 111L;
        Optional<Product> product = productRepository.findById(id);

        this.mockMvc.perform(get("/api/products/" + id)
                        .contentType(APPLICATION_JSON)
                        .content("{\"id\":111,\"name\":\"cucumber\",\"bought\":\"false\"}"))
                .andDo(print())
                .andExpect(content().string(containsString(product.get().getName())))
                .andExpect(status().isOk());
    }
}