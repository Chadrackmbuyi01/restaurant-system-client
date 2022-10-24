/**
 * Payment.java
 * Payment entity for Restaurant System using Builder Pattern
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 06 April 2022
 */

package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Payment {
    @Id
     private String paymentId;
     private String payCash;
     private String payCard;
     private String payEft;

    public Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.payCash = builder.payCash;
        this.payCard = builder.payCard;
        this.payEft = builder.payEft;
    }

    public Payment(){

    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPayCash() {
        return payCash;
    }

    public String getPayCard() {
        return payCard;
    }

    public String getPayEft() {
        return payEft;
    }


    //toString
    @Override
    public String toString() {
        return "Payment{" +
                ", paymentId" + paymentId + '\'' +
                ", payCash=" + payCash + '\'' +
                ", payCard=" + payCard + '\'' +
                ", payEft=" + payEft + '\'' +
                '}';
    }

    //Builder Pattern Class

    public static class Builder {
         private String paymentId;
         private String payCash;
         private String payCard;
         private String payEft;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPayCash(String payCash) {
            this.payCash = payCash;
            return this;
        }

        public Builder setPayCard(String payCard) {
            this.payCard = payCard;
            return this;
        }

        public Builder setPayEft(String payEft) {
            this.payEft = payEft;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.payCash = payment.payCash;
            this.payCard = payment.payCard;
            this.payEft = payment.payEft;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}