package com.example.Wood.services.impls;

import com.example.Wood.dtos.CartDto;
import com.example.Wood.models.Cart;
import com.example.Wood.models.Product;
import com.example.Wood.models.User;
import com.example.Wood.repositories.CartRepository;
import com.example.Wood.repositories.ProductRepository;
import com.example.Wood.repositories.UserRepository;
import com.example.Wood.services.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
//    ----------------ozumcun
    private final ModelMapper modelMapper;
    @Override
    public List<CartDto> getCartItemsByUserName(String username) {
        return cartRepository.findByUserUsername(username).stream().map(cart -> new CartDto(
                cart.getId(),
                cart.getName(),
                cart.getImageUrl(),
                cart.getQuantity(),
                cart.getPrice()


        )).toList();
    }

    @Override
    public double calculateSubtotal(List<CartDto> cartItems) {
        return cartItems.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public void addToCart(String username, Long productId) {
        User user = userRepository.findByEmail(username);
        Product product = productRepository.findById(productId).orElseThrow();

//        Cartlari bir bir yox ustune elave edir. yeni alt alta yox sayini artirir
        Cart existing = cartRepository.findByUserAndProduct(user, product);
        if (existing != null) {
            System.out.println("Artırıldı");
            existing.setQuantity(existing.getQuantity() + 1);
            cartRepository.save(existing);
        } else {
            System.out.println("Yeni əlavə edildi");
            Cart newCart = new Cart();
            newCart.setUser(user);
            newCart.setProduct(product);
            newCart.setQuantity(1);
            newCart.setName(product.getName());
            newCart.setImageUrl(product.getImageUrl());
            newCart.setPrice(product.getPrice());
            cartRepository.save(newCart);
        }
    }
//-------------------ozumcun
//    @Override
//    public List<CartDto> getAllCarts() {
//        List<CartDto> cartDtos=cartRepository.findAll().stream().map(cart -> modelMapper.map(cart,CartDto.class)).collect(Collectors.toList());
//        return cartDtos;
//    }
}
