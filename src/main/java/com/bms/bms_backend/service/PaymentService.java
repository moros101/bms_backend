package com.bms.bms_backend.service;

public interface PaymentService {
    String initiatePayment(Long bookingId);

    String paymentFallback(Long bookingId, Throwable t);
}
