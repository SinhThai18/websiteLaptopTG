package com.web.laptoptg.service;

import com.web.laptoptg.model.Cart;
import com.web.laptoptg.model.User;

public interface CartService {
    Cart getCartByUser(User user);
    void saveCart(Cart cart);
    void updateCart(Cart cart);
}
