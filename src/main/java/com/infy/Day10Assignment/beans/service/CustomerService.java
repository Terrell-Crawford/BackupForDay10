package com.infy.Day10Assignment.beans.service;

import com.infy.Day10Assignment.Entity.Customer;
import com.infy.Day10Assignment.beans.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService{
    private static Logger logger= LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository cRepo;
    @Autowired
    public CustomerService(CustomerRepository cRepo){
        this.cRepo=cRepo;
    }

    public Customer createCustomer(Customer customer) throws Exception {
        if(customer.getCustomerId()!=null|| cRepo.getCustomerByAccNum(customer.getCustomerAccNum())!=null || customer.getCustomerAccNum()==null){
            throw new Exception();
        }else return cRepo.save(customer);
    }

    public Customer updateCustomer(Customer customer) throws Exception {
        if(customer.getCustomerId()==null || !cRepo.findById(customer.getCustomerId()).isPresent()){
            throw new Exception();
        }else return cRepo.save(customer);
    }
    public void deleteCustomer(Customer customer) throws Exception {
       Customer customerToDelete=cRepo.getCustomerByAccNum(customer.getCustomerAccNum());
        if(customerToDelete.getCustomerId()==null || !cRepo.findById(customerToDelete.getCustomerId()).isPresent()){
            throw new Exception();
        }else{cRepo.delete(customerToDelete);}
    }
    public Customer getCustomerById(Integer id){
        return cRepo.getReferenceById(id);
    }
    public List<Customer> getAllCustomers(){
        return cRepo.findAll();
    }
    public Customer getByAccountNumber(Long accNum){
        return cRepo.getCustomerByAccNum(accNum);
    }

}
