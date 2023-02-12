package com.eshop.mycoolshop.api;

import com.eshop.mycoolshop.models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String addStudent(@ModelAttribute("listing") Listing listing) {
        service.add(listing);
        return "redirect:";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("new");
        Listing listing = service.get(id);
        mav.addObject("listing", listing);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteListing(@PathVariable(name = "id") String id) {
        service.delete(id);
        return "redirect:/";
    }
}
