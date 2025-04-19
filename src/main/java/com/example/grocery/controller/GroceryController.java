package com.example.grocery.controller;

import com.example.grocery.model.Product;
import com.example.grocery.model.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class GroceryController {

    private List<Product> productList = new ArrayList<>();
    private Map<Integer, CartItem> cart = new HashMap<>();

    public GroceryController() {
        // Add some static products
        productList.add(new Product(1, "Tomato", 20, "tomato.jpg"));
        productList.add(new Product(2, "Onion", 25, "Onion-Orange.webp"));
        productList.add(new Product(3, "Potato", 18, "potato.jpg"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productList);
        return "home";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam int productId, @RequestParam int quantity, RedirectAttributes redirectAttributes) {
        Product selected = productList.stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null);

        if (selected != null) {
            CartItem item = cart.getOrDefault(productId, new CartItem(selected, 0));
            item.setQuantity(item.getQuantity() + quantity);
            cart.put(productId, item);
        }

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cart.values());
        return "cart";
    }
}
