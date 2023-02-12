package com.eshop.mycoolshop.api;

import com.eshop.mycoolshop.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopRepository extends JpaRepository<Listing, String> {
}

