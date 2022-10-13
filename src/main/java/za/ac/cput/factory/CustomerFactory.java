/* Customer.java
   Factory for Customer
   Author: Ismail Watara
   Student Number: 219018790
   Date: March 2022
*/

package za.ac.cput.factory;
import za.ac.cput.domain.Customer;

public class CustomerFactory {
    public static Customer createcustomer(String custId, String custFirstName, String custLastName, int custCellNum, String custEmail) {
        return new Customer.Builder().setCustId(custId)
                .setCustFirstName(custFirstName)
                .setCustLastName(custLastName)
                .setcustCellNum(custCellNum)
                .setcustEmail(custEmail)
                .build();
    }
}
        
        
    
