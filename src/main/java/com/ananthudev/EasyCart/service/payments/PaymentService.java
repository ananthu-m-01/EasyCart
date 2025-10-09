package com.ananthudev.EasyCart.service.payments;

import com.ananthudev.EasyCart.dto.payment.CreatePaymentDTO;
import com.ananthudev.EasyCart.dto.payment.ResponsePaymentDTO;
import com.ananthudev.EasyCart.dto.payment.UpdatePaymentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Override
    public List<ResponsePaymentDTO> getAllPayments() {
        return List.of();
    }

    @Override
    public ResponsePaymentDTO getPaymentById(Long id) {
        return null;
    }

    @Override
    public ResponsePaymentDTO getPaymentByOrderId(Long orderId) {
        return null;
    }

    @Override
    public ResponsePaymentDTO makePayment(CreatePaymentDTO createPaymentDTO) {
        return null;
    }

    @Override
    public ResponsePaymentDTO updatePaymentById(Long id,UpdatePaymentDTO updatePaymentDTO) {
        return null;
    }
}
