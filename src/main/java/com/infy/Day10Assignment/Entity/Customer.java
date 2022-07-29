package com.infy.Day10Assignment.Entity;



import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    @NotBlank(message = "Name can't be empty")
    private String customerName;
    @Column(name = "customer_phone")
    private String customerNo;
    @Email
    @Column(name = "customer_email")
    private String customerEmailId;
    @Column(name = "customer_address")
    private String customerAddress;
    @NotNull
    @Column(name = "customer_account_num", unique = true)
    private Long customerAccNum;
    @Column(name = "customer_balance")
    private Long customerBalance;

    public Customer(){}
    public Customer(String customerName, String customerNo, String customerEmailId, String customerAddress, Long customerAccNum, Long customerBalance){
        this.customerName=customerName;
        this.customerNo=customerNo;
        this.customerEmailId=customerEmailId;
        this.customerAddress=customerAddress;
        this.customerAccNum=customerAccNum;
        this.customerBalance=customerBalance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getCustomerAccNum() {
        return customerAccNum;
    }

    public void setCustomerAccNum(Long customerAccNum) {
        this.customerAccNum = customerAccNum;
    }

    public Long getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(Long customerBalance) {
        this.customerBalance = customerBalance;
    }
}
