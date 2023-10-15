package com.pucmg.adviser.repositories.impl;

import com.pucmg.adviser.models.Transaction;
import com.pucmg.adviser.repositories.TransactionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TransactionRepositoryDefault implements TransactionRepository {

    private static final Map<String, Transaction> TRANSACTIONS = new HashMap<>();

    @Override
    public Optional<Transaction> get(String clientId, String transactionId) {
        Transaction transaction = TRANSACTIONS.get(compoundKey(clientId, transactionId));
        return Optional.ofNullable(transaction);
    }

    @Override
    public void upsert(Transaction transaction) {
        TRANSACTIONS.put(compoundKey(transaction.getClientId(), transaction.getTransactionId()), transaction);
    }

    private static String compoundKey(String clientId, String transactionId) {
        return clientId.concat("-").concat(transactionId);
    }
}
