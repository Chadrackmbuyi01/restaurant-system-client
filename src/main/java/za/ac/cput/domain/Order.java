/* Customer.java
   Entity for Order
   Author: Ismail Watara
   Student Number: 219018790
   Date: March 2022
*/




package za.ac.cput.domain;

public class Order {
    private String orderId;
    private String orderItem;


    private Order(Builder builder){
        this.orderId = builder.orderId;
        this.orderItem = builder.orderItem;


    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItem='" + orderItem + '\'' +
                '}';

    }

    public static class Builder {
        private String orderId;
        private String orderItem;

        public Builder setorderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setorderItem(String orderItem) {
            this.orderItem = orderItem;
            return this;
        }

        public Builder copy(Order order){
            this.orderId = order.orderId;
            this.orderItem = order.orderItem;
            return this;
        }
        public Order build(){
            return new Order(this);
        }
    }

}
