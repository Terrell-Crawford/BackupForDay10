package com.infy.Day10Assignment.dto;

public class CustomerDTO {
    private String customerName;
    private String customerNo;
    private String customerEmailId;
    private String customerAddress;
    private Long customerAccNum;
    private Long customerBalance;
    public CustomerDTO(Long customerAccNum, Long customerBalance){
        this.customerAccNum=customerAccNum;
        this.customerBalance=customerBalance;
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
}
