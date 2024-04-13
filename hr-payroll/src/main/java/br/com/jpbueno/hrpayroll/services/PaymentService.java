package br.com.jpbueno.hrpayroll.services;

import br.com.jpbueno.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("João", 200.0, days);
    }
}
