/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbdx.service;

import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Refund;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.stereotype.Service;

/**
 *
 * @author quang
 */
public interface PaypalService {

     Payment createPayment( Double total,
            String currency,
            String method,
            String intent,
            String description,
            String cancelUrl,
            String successUrl)throws PayPalRESTException ;
      Payment executePayment(String paymentId, String payerId) throws PayPalRESTException ;
        Refund refundPayment(String saleId, String currency, String total) throws PayPalRESTException ;
}
