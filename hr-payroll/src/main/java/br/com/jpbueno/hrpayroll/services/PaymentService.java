package br.com.jpbueno.hrpayroll.services;

import br.com.jpbueno.hrpayroll.entities.Payment;
import br.com.jpbueno.hrpayroll.entities.Worker;
import br.com.jpbueno.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findByIdWorker(workerId).getBody();

        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
