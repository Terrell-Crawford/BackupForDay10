package com.infy.Day10Assignment.beans.repository;

import com.infy.Day10Assignment.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //@Query(value = "FROM Customer WHERE customerAccNum= :accNum")
    Customer getByCustomerAccNum(Long accNum);
}
