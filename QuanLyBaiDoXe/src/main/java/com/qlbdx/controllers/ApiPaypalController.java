/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbdx.controllers;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Refund;
import com.paypal.api.payments.RelatedResources;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import com.qlbdx.service.PaypalService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author quang
 */
@RestController
@CrossOrigin
public class ApiPaypalController {

    @Autowired
    private PaypalService service;

    public static final String SUCCESS_URL = "/";
    public static final String CANCEL_URL = "pay/cancel";

    @PostMapping(path = "/api/paypal/pay", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String payment(@RequestParam Map<String, String> params) throws PayPalRESTException {
        System.out.println(Double.valueOf(params.get("amount")));
        System.out.println(params.get("currency"));

        Payment payment = service.createPayment(Double.valueOf(params.get("amount")),
                "USD", "paypal",
                "sale", "Thanh toan paypal",
                "http://localhost:3000/cancel",
                "http://localhost:3000/success");
        for (Links link : payment.getLinks()) {
            if (link.getRel().equals("approval_url")) {
                return  link.getHref();
            }
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @PostMapping(path = "/api/successPaypal")
    @CrossOrigin
    public ResponseEntity<?> successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) throws PayPalRESTException {
        System.out.println("dawdawdawdawd");
        Payment payment = service.executePayment(paymentId, payerId);
//        System.out.println(payment.toJSON());
        if (payment.getState().equals("approved")) {
             List<Map<String, Object>> relatedResourcesList = new ArrayList<>();
             RelatedResources resource = payment.getTransactions().get(0).getRelatedResources().get(0);
             System.out.println(resource.getSale().getId());
            return new ResponseEntity<>(resource.getSale().getId(),HttpStatus.OK);
        }
            return new ResponseEntity<>("Loi thanh toan",HttpStatus.OK);
    }

    @PostMapping("/api/paypal/refund")
    @CrossOrigin
    public ResponseEntity<?> refundPayment(@RequestParam String saleId,
            @RequestParam String amount){
        try{
            Refund refund =  service.refundPayment(saleId, "USD", amount);
        }
        catch (PayPalRESTException e){
             return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.OK);
        } 
        return new ResponseEntity<>("Hoàn tiền thành công", HttpStatus.OK);
    }
}
