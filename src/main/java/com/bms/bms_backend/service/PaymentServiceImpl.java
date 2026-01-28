package com.bms.bms_backend.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    @Override
    public String initiatePayment(Long bookingId) {
        String url = "https://payments.api/initiate/" + bookingId;
        return restTemplate.getForObject(url, String.class);

    }

    @Override
    public String paymentFallback(Long bookingId, Throwable t) {
        return "Payment service unavailable. Try again later for bookingId :" + bookingId;
    }
}
