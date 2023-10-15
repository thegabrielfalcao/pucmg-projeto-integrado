package com.pucmg.adviser.services.impl;

import com.pucmg.adviser.models.Transaction;
import com.pucmg.adviser.repositories.TransactionRepository;
import com.pucmg.adviser.repositories.impl.TransactionRepositoryDefault;
import com.pucmg.adviser.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceDefault implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceDefault() {
        this.repository = new TransactionRepositoryDefault();
    }
    @Override
    public Optional<Transaction> get(String clientId, String transactionId) {
        return repository.get(clientId, transactionId);
    }

    @Override
    public void upsert(Transaction transaction) {
        repository.upsert(transaction);
    }
}
