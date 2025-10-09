package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.payment.CreatePaymentDTO;
import com.ananthudev.EasyCart.dto.payment.ResponsePaymentDTO;
import com.ananthudev.EasyCart.dto.payment.UpdatePaymentDTO;
import com.ananthudev.EasyCart.service.payments.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    private PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @GetMapping("/payments")
    public List<ResponsePaymentDTO> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/payments/{id}")
    public ResponsePaymentDTO getPaymentsById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/payments/orders/{orderId}")
    public ResponsePaymentDTO getPaymentsByOrderId(@PathVariable Long orderId){
        return paymentService.getPaymentByOrderId(orderId);
    }

    @PostMapping("/payments")
    public ResponsePaymentDTO makePayment(@RequestBody CreatePaymentDTO createPaymentDTO){
        return paymentService.makePayment(createPaymentDTO);
    }

    @PutMapping("/payments/{id}")
    public ResponsePaymentDTO updatePayment(@PathVariable Long id, UpdatePaymentDTO updatePaymentDTO){
        return paymentService.updatePaymentById(id,updatePaymentDTO);
    }
}
