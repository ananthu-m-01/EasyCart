package com.ananthudev.EasyCart.service.payments;

import com.ananthudev.EasyCart.dto.payment.CreatePaymentDTO;
import com.ananthudev.EasyCart.dto.payment.ResponsePaymentDTO;
import com.ananthudev.EasyCart.dto.payment.UpdatePaymentDTO;

import java.util.List;

public interface IPaymentService {
    List<ResponsePaymentDTO> getAllPayments();
    ResponsePaymentDTO getPaymentById(Long id);
    ResponsePaymentDTO getPaymentByOrderId(Long orderId);
    ResponsePaymentDTO makePayment(CreatePaymentDTO createPaymentDTO);
    ResponsePaymentDTO updatePaymentById(Long id,UpdatePaymentDTO updatePaymentDTO);
}
