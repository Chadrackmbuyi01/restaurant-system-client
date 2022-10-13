/* Customer.java
   Factory for Order
   Author: Ismail Watara
   Student Number: 219018790
   Date: March 2022
*/


package za.ac.cput.factory;

import za.ac.cput.domain.Order;

public class OrderFactory {

    public static Order createorder(String orderId, String orderItem) {
        return new Order.Builder().
                setorderId(orderId)
                .setorderItem(orderItem)
                .build();

    }
}
