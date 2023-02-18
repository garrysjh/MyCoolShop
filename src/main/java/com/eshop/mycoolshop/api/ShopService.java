package com.eshop.mycoolshop.api;

import com.eshop.mycoolshop.models.Cart;
import com.eshop.mycoolshop.models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository repository;
    @Autowired
    private CartRepository cartRepo;

    public List<Listing> listAll(){
        return repository.findAll();
    }

    public List<Cart> listAllCart(){
        return cartRepo.findAll();
    }
    public void add(Cart cart){
        cartRepo.save(cart);
    }
    public Listing get(String Id){
        return repository.findById(Id).get();
    }

    public Cart getCart(String Id){
        return cartRepo.findById(Id).get();
    }

    public void delete(Cart cart) {cartRepo.delete(cart);
    }
    public Cart addToCart(Listing listing) {
        Cart newCart = new Cart();
        newCart.setId(listing.getId());
        newCart.setTitle(listing.getTitle());
        newCart.setDescription(listing.getDescription());
        newCart.setImage(listing.getImage());
        newCart.setPrice(listing.getPrice());

        return newCart;
    }

}
