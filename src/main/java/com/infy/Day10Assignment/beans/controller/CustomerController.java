package com.infy.Day10Assignment.beans.controller;

import com.infy.Day10Assignment.Entity.Customer;
import com.infy.Day10Assignment.beans.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private ResponseEntity<List<Long>> getAllBalances(){
        List<Long> balances= new ArrayList<>();
        for(Customer c: cServ.getAllCustomers()){
            balances.add(c.getCustomerBalance());
        }
        return ResponseEntity.status(200).body(balances);
    }
    @GetMapping("/id/{id}")
    private ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cServ.getById(id));
        } catch (Exception e) {
            System.out.println("No customer with id "+ id +" exists!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
    @GetMapping("/acc/{accNum}")
    private ResponseEntity<Customer> getCustomerByAccountNumber(@PathVariable Long accNum){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cServ.getByAccountNumber(accNum));
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/add")
    private ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cServ.createCustomer(customer));
        } catch (Exception e) {
            return ResponseEntity.status(409).body(null);
        }
    }
    @PutMapping("/update")
    private ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer){
       try{
        Customer updatedCustomer=cServ.getByAccountNumber(customer.getCustomerAccNum());
        updatedCustomer.setCustomerBalance(customer.getCustomerBalance());
        updatedCustomer.setCustomerName(customer.getCustomerName());
        updatedCustomer.setCustomerNo(customer.getCustomerNo());
        updatedCustomer.setCustomerAddress(customer.getCustomerAddress());
        updatedCustomer.setCustomerEmailId(customer.getCustomerEmailId());

            return ResponseEntity.status(204).body(cServ.updateCustomer(updatedCustomer));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
    @DeleteMapping("/remove")
    private ResponseEntity<String> deleteCustomer(@Valid @RequestBody Customer customer){
        try {
            Customer customerToDelete=cServ.getByAccountNumber(customer.getCustomerAccNum());
            cServ.deleteCustomer(customerToDelete);
            return ResponseEntity.status(HttpStatus.OK).body("Customer Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("That customer doesn't exist");
        }

    }
}
