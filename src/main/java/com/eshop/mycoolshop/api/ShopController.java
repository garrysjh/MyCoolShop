package com.eshop.mycoolshop.api;

import com.eshop.mycoolshop.models.Cart;
import com.eshop.mycoolshop.models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ShopService service;
    @Autowired
    private ShopRepository repository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Listing> ListListing = service.listAll();
        model.addAttribute("listing", ListListing);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Cart> cartt = service.listAllCart();
        model.addAttribute("cart", cartt);
        System.out.print("Get / cart ");
        return "shoppingcart";
    }
    @GetMapping("/123")
    public List<Listing> index(){
        return repository.findAll();
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("listing", new Listing());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addCart(@ModelAttribute("cart") Cart cart) {
        service.add(cart);
        return "redirect:";
    }

    @RequestMapping(value = "/save/{id}", method = { RequestMethod.GET })
    public String addByID(@PathVariable(name = "id") String id) {
        service.add(service.addToCart(service.get(id)));
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("new");
        Listing listing = service.get(id);
        mav.addObject("listing", listing);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable(name = "id") String id) {
        service.delete(service.getCart(id));
        return "redirect:/cart";
    }

}
