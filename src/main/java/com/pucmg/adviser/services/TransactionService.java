package com.pucmg.adviser.services;

import com.pucmg.adviser.models.Transaction;

import java.util.Optional;

public interface TransactionService {
    Optional<Transaction> get(String clientId, String transactionId);
    void upsert(Transaction transaction);
}
