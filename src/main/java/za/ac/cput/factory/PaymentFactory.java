/**
 * PaymentFactory.java
 * Payment Factory for Payment Entity in Restaurant System
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 07 April 2022
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Payment;

public class PaymentFactory {
    public static Payment createPayment(String paymentId, String payCash, String payCard, String payEft) {
        return new Payment.Builder().setPaymentId(paymentId)
                .setPayCash(payCash)
                .setPayCard(payCard)
                .setPayEft(payEft)
                .build();
    }
}
