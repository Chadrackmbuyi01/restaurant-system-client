/* Customer.java
   Entity for Customer
   Author: Ismail Watara
   Student Number: 219018790
   Date: March 2022
*/




package za.ac.cput.domain;

import java.io.Serializable;

public class Customer implements Serializable {

     private String custId;
     private String custFirstName;
     private String custLastName;
     private int custCellNum;
     private String custEmail;

    public Customer(Builder builder){
        this.custId = builder.custId;
        this.custFirstName = builder.custFirstName;
        this.custLastName = builder.custLastName;
        this.custCellNum = builder.custCellNum;
        this.custEmail = builder.custEmail;
    }

    public Customer(){

    }
    public String getCustId() {
        return custId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public int getCustCellNum() {
        return custCellNum;
    }

    public String getCustEmail() {
        return custEmail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", custFirstName='" + custFirstName + '\'' +
                ", custLastName='" + custLastName + '\'' +
                ", custCellNum=" + custCellNum +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }

    public static class Builder{

         private String custId;
         private String custFirstName;
         private String custLastName;
         private  int custCellNum;
         private String custEmail;

        public Builder setCustId(String custId){
            this.custId = custId;
            return this;
        }
        public Builder setCustFirstName(String custFirstName) {
            this.custFirstName = custFirstName;
            return this;
        }

        public Builder setCustLastName(String custLastName) {
            this.custLastName = custLastName;
            return this;
        }

        public Builder setcustCellNum(int custCellNum){
            this.custCellNum = custCellNum;
            return this;
        }

        public Builder setcustEmail(String custEmail){
            this.custEmail = custEmail;
            return this;
        }

        public Builder copy(Customer customer){
            this.custId =customer.custId;
            this.custFirstName = customer.custFirstName;
            this.custLastName = customer.custLastName;
            this.custCellNum = customer.custCellNum;
            this.custEmail = customer.custEmail;
            return this;
        }
        public Customer build(){
            return new Customer(this);


        }
    }

}
