package com.infy.Day10Assignment.beans.repository;

import com.infy.Day10Assignment.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "FROM Customer WHERE customerAccNum= :accNum")
    Customer getCustomerByAccNum(@Param("accNum") Long accNum);
}
