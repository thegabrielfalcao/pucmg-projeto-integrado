package com.pucmg.adviser.repositories;

import com.pucmg.adviser.models.Transaction;

import java.util.Optional;

public interface TransactionRepository {

    Optional<Transaction> get(String transactionId, String clientId);
    void upsert(Transaction transaction);
}
