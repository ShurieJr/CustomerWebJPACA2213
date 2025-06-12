package com.example.demoJPACA2213;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String getHome(){
        return "index";   //view name // page name
    }

    @GetMapping("/register")
    public String register(){
        return "register";  // registration page
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        Collection<Customer> list = service.getAllCustomer();
        model.addAttribute("customers" , list);
         return "view";
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    @PostMapping("/save")
    public String add(@ModelAttribute Customer customer) {
        service.addCustomer(customer);
        return "redirect:/all";
    }

    /// delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/all";
    }

    //update
    @RequestMapping("/update")
    public String update(@ModelAttribute Customer newCustomer) {
        service.updateCustomer(newCustomer);
        return "redirect:/all";
    }

    @RequestMapping("/Edit/{id}")
    public String edit(@PathVariable int id ,Model model){
        Customer customer = service.getCustomerById(id);
        model.addAttribute("customer" , customer);
        return "Edit";
    }
}
