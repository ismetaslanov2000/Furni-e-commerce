package com.example.Wood.controllers;

import com.example.Wood.dtos.PostDto;
import com.example.Wood.dtos.ProductDto;
import com.example.Wood.services.PostService;
import com.example.Wood.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;
    private final PostService postService;


    @GetMapping("/")
    public  String home(Model model){
        List<ProductDto> productDtoList=productService.getALlProducts();
        model.addAttribute("products",productDtoList);

        return "index.html";
    }
    @GetMapping("/about")
    public  String about(){
        return "about.html";
    }
    @GetMapping("/blog")
    public  String blog(Model model){
        List<PostDto> postDtoList=postService.getALlBlogs();
        model.addAttribute("blogs",postDtoList);

        return "blog.html";
    }
    @GetMapping("/services")
    public  String services(Model model){
        List<ProductDto> productDtoList=productService.getALlServicess();
        model.addAttribute("servicess",productDtoList);
        return "services.html";
    }
    @GetMapping("/contact")
    public  String contact(){
        return "contact.html";
    }
    @GetMapping("/cart")
    public  String cart(){
        return "cart.html";
    }
    @GetMapping("/shop")
    public  String shop(Model model){
        List<ProductDto> productDtoList=productService.getALlShops();
        model.addAttribute("shops",productDtoList);
        return "shop.html";
    }
}
