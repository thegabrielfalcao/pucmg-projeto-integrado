package com.pucmg.adviser.controllers.impl;

import com.pucmg.adviser.controllers.TransactionController;
import com.pucmg.adviser.models.Transaction;
import com.pucmg.adviser.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("transactions")
public class TransactionControllerDefault implements TransactionController {

    private final TransactionService transactionService;

    public TransactionControllerDefault(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity find(@RequestHeader("Client-Id") String clientId, @PathVariable("id") String transactionId) {
        Optional<Transaction> transaction = transactionService.get(clientId, transactionId);
        if (transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        }

        return ResponseEntity.notFound().build();
    }
}
