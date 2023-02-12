package com.eshop.mycoolshop.api;

import com.eshop.mycoolshop.models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository repository;

    public List<Listing> listAll(){
        return repository.findAll();
    }
    public void add(Listing listing){
        repository.save(listing);
    }
    public Listing get(String Id){
        return repository.findById(Id).get();
    }
    public void delete(String Id) {
        repository.deleteById(Id);
    }


}
