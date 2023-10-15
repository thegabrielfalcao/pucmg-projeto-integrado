package com.pucmg.adviser.clients.impl;

import com.pucmg.adviser.models.QueueMessage;
import com.pucmg.adviser.clients.QueueClient;
import org.springframework.stereotype.Service;

@Service
public class QueueClientDefault implements QueueClient {
    @Override
    public void publish(QueueMessage message) {
        System.out.println("Mensagem enviada com sucesso");
    }
}
