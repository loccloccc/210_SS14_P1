package org.example.bai1.repository.impl;

import jakarta.transaction.Transactional;
import org.example.bai1.model.Order;
import org.example.bai1.model.Wallet;
import org.example.bai1.repository.ITransactionRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TransactionRepository implements ITransactionRepository {

    private final SessionFactory sessionFactory;

    public TransactionRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void processPayment(Long orderId, Long walletId, double totalAmount) {

        Session session = sessionFactory.getCurrentSession();


        Order order = session.get(Order.class, orderId);
        order.setStatus("PAID");


        if (true) throw new RuntimeException("Kết nối đến cổng thanh toán thất bại!");


        Wallet wallet = session.get(Wallet.class, walletId);

        if (wallet.getBalance() < totalAmount) {
            throw new RuntimeException("Không đủ tiền!");
        }

        wallet.setBalance(wallet.getBalance() - totalAmount);
    }
}