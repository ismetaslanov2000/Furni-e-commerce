package com.example.Wood.controllers;

import com.example.Wood.dtos.CartDto;
import com.example.Wood.models.Cart;
import com.example.Wood.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

//    ----------------ozumcun
    @GetMapping("/cart")
    public  String cart(Model model){
        List<CartDto> cartDtoList = cartService.getAllCarts();
        model.addAttribute("cartItems", cartDtoList);

        return "cart.html";
    }
//------------------esas

//    @GetMapping("/cart")
//    private String cart(Model model, Principal principal) {
//        if (principal == null) {
//            return "redirect:/login";
//        }
//        String username = principal.getName();
//        List<Cart> cartItems = cartService.getCartItemsByUserName(username);
//        double subtotal = cartService.calculateSubtotal(cartItems);
//        model.addAttribute("cartItems", cartItems);
//        model.addAttribute("cartTotal", subtotal);
//
//        return "cart.html";
//    }
//
//    @PostMapping("/cart/add")
//    public String addToCart(@RequestParam Long productId, Principal principal) {
//        if (principal == null) return "redirect:/login";
//
//        String username = principal.getName();
//        cartService.addToCart(username, productId);
//        return "redirect:/cart";
//    }
}
