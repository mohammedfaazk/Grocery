package com.example.grocery;

import com.example.grocery.controller.GroceryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GroceryApplicationIntegrationTest {

    @Autowired
    private GroceryController controller;

    @Test
    void contextLoads() {
        // Simple test to verify that the application context loads
        assertThat(controller).isNotNull();
    }
}
