package com.pucmg.adviser.services.impl;

import com.pucmg.adviser.clients.QueueClient;
import com.pucmg.adviser.dtos.ItemDTO;
import com.pucmg.adviser.enums.Status;
import com.pucmg.adviser.models.QueueMessage;
import com.pucmg.adviser.models.Transaction;
import com.pucmg.adviser.services.ItemService;
import com.pucmg.adviser.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceDefault implements ItemService {

    private final QueueClient queueClient;
    private final TransactionService transactionService;

    public ItemServiceDefault(QueueClient queueClient, TransactionService transactionService) {
        this.queueClient = queueClient;
        this.transactionService = transactionService;
    }
    @Override
    public List<Transaction> batch(String clientId, List<ItemDTO> items) {
        List<QueueMessage> messages = items.stream()
                .map(i -> createMessage(clientId, i))
                .toList();

        return messages.stream()
                .map(this::publish)
                .toList();
    }

    private Transaction publish(QueueMessage message) {
        Transaction.Builder builder = new Transaction.Builder()
                .withClientId(message.getClientId())
                .withTransactionId(message.getTransactionId())
                .withItemId(message.getItem().getId());

        try {
            queueClient.publish(message);
            builder.withStatus(Status.OK);
        } catch (RuntimeException exception) {
            builder.withStatus(Status.ERROR);
        }

        Transaction transaction = builder.build();
        transactionService.upsert(transaction);
        return transaction;
    }

    private QueueMessage createMessage(String clientId, ItemDTO item) {
        return new QueueMessage.Builder()
                .withClientId(clientId)
                .withTransactionId(UUID.randomUUID().toString())
                .withItem(item)
                .build();
    }
}
