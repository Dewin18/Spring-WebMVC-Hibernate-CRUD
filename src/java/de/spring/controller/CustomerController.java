package de.spring.controller;

import de.spring.entity.Customer;
import de.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomersGET(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/showAddCustomerForm")
    public String addCustomers(Model model) {
        Customer customer = new Customer();
        model.addAttribute(customer);

        return "add-customers";
    }

    @PostMapping("/add")
    public String listCustomersPOST(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return  "add-customers";
        }

        customerService.addCustomer(customer);
        return "redirect:list";  // PRG-Pattern
    }

    @GetMapping("/showEditCustomerForm")
    public String showUpdate(@RequestParam("customerId") int customerId, Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer); // old customer
        model.addAttribute("customerId", customerId);
        return "edit-customers";
    }

    @PostMapping("/edit")
    public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer,  BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return  "edit-customers";
        }

        customerService.updateCustomer(customer);
        return "redirect:list";
    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:list";
    }
}