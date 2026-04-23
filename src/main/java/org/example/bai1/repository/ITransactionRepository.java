package org.example.bai1.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository {
    public void processPayment(Long orderId, Long walletId, double totalAmount);

}
