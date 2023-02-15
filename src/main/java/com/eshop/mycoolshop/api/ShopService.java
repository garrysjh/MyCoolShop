package com.eshop.mycoolshop.api;

import com.eshop.mycoolshop.models.Cart;
import com.eshop.mycoolshop.models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void delete(String Id) {
        repository.deleteById(Id);
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
