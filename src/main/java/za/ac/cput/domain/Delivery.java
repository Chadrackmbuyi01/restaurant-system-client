/*
Delivery.java
Entity for delivery using builder pattern
Author : Zubair Esau (217100554)
Date 05 April 2022

 */

package za.ac.cput.domain;




public class Delivery {
    private String DeliveryId ;
    private String OrderId ;

    // private constructor
    private Delivery (Builder builder){
        super();
        this.DeliveryId = builder.DeliveryId;
        this.OrderId = builder.OrderId;
    }


    //Getters and setters
    public String getDeliveryId() {
        return DeliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        DeliveryId = deliveryId;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    //toString


    @Override
    public String toString() {
        return "Delivery{" +
                "DeliveryId='" + DeliveryId + '\'' +
                ", OrderId='" + OrderId + '\'' +
                '}';
    }

    //Builder pattern class
    public static class Builder{
        private String DeliveryId ;
        private String OrderId ;

        public Builder setDeliveryId(String deliveryId) {
            DeliveryId = deliveryId;
            return this;
        }

        public Builder setOrderId(String orderId) {
            OrderId = orderId;
            return this;
        }

        public Builder copy(Delivery delivery){
            this.DeliveryId = DeliveryId;
            this.OrderId = OrderId;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }

    }




}


