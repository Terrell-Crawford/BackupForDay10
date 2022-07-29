package com.infy.Day10Assignment.beans.service;

import com.infy.Day10Assignment.Entity.Customer;
import com.infy.Day10Assignment.beans.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService{
    private final CustomerRepository cRepo;
    @Autowired
    public CustomerService(CustomerRepository cRepo){
        this.cRepo=cRepo;
    }

    public Customer createCustomer( Customer customer) throws Exception {
        if(customer.getCustomerId()!=null|| cRepo.getByCustomerAccNum(customer.getCustomerAccNum())!=null || customer.getCustomerAccNum()==null){
            throw new Exception();
        }else return cRepo.save(customer);
    }

    public Customer updateCustomer(Customer customer) throws Exception {
        if(customer.getCustomerId()==null || !cRepo.findById(customer.getCustomerId()).isPresent()){
            throw new Exception();
        }else return cRepo.save(customer);
    }
    public void deleteCustomer( Customer customer) throws Exception {
       Customer customerToDelete=cRepo.getByCustomerAccNum(customer.getCustomerAccNum());
        if(customerToDelete.getCustomerId()==null || !cRepo.findById(customerToDelete.getCustomerId()).isPresent()){
            throw new Exception();
        }else{cRepo.delete(customerToDelete);}
    }

    public List<Customer> getAllCustomers(){
        return cRepo.findAll();
    }

    public Customer getById(Integer id) throws Exception {
        if(!cRepo.findById(id).isPresent()){
           throw new Exception();
        }else return cRepo.findById(id).get();

    }
    public Customer getByAccountNumber(Long accNum) throws Exception {
        if(cRepo.getByCustomerAccNum(accNum)==null){
            throw new Exception();
        }else return cRepo.getByCustomerAccNum(accNum);
    }

}
