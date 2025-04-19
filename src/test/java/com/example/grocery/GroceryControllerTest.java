package com.example.grocery;

import com.example.grocery.controller.GroceryController;
import com.example.grocery.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroceryControllerTest {

    private GroceryController controller;
    
    @BeforeEach
    void setUp() {
        controller = new GroceryController();
    }

    @Test
    void home_ShouldReturnHomeViewWithProducts() {
        Model model = mock(Model.class);
        String viewName = controller.home(model);
        
        assertEquals("home", viewName);
        verify(model).addAttribute(eq("products"), anyList());
    }

    @Test
    void addToCart_ShouldAddProductToCartAndRedirect() {
        int productId = 1;
        int quantity = 2;
        
        String redirect = controller.addToCart(productId, quantity, mock(RedirectAttributes.class));
        
        assertEquals("redirect:/cart", redirect);
        // You could add more assertions here to verify cart contents
    }

    @Test
    void viewCart_ShouldReturnCartViewWithCartItems() {
        Model model = mock(Model.class);
        String viewName = controller.viewCart(model);
        
        assertEquals("cart", viewName);
        verify(model).addAttribute(eq("cartItems"), anyCollection());
    }
}