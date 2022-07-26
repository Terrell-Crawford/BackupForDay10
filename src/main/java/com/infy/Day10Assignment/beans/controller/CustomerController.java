package com.infy.Day10Assignment.beans.controller;

import com.infy.Day10Assignment.Entity.Customer;
import com.infy.Day10Assignment.beans.service.CustomerService;
import com.infy.Day10Assignment.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService cServ;
    @Autowired
    public CustomerController(CustomerService cServ){
        this.cServ=cServ;
    }
    @GetMapping("/details")
    private List<Long> getAllBalances(){
        List<Long> balances= new ArrayList<>();
        for(Customer c: cServ.getAllCustomers()){
            balances.add(c.getCustomerBalance());
        }
        return balances;
    }
    @PostMapping("/add")
    private ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(cServ.createOrUpdateCustomer(customer));
    }
    @PutMapping("/update")
    private Customer updateCustomer(@RequestBody Customer customer){
        Customer updatedCustomer=cServ.getByAccountNumber(customer.getCustomerAccNum());
        customer.setCustomerBalance(customer.getCustomerBalance());
        return cServ.createOrUpdateCustomer(updatedCustomer);
    }
    @DeleteMapping("/remove")
    private ResponseEntity<String> deleteCustomer(@RequestBody Customer customer){
        try {
            cServ.deleteCustomer(customer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("That customer doesn't exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Customer Deleted");
    }
}
