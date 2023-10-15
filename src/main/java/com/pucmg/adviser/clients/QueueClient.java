package com.pucmg.adviser.clients;

import com.pucmg.adviser.models.QueueMessage;

public interface QueueClient {

    void publish(QueueMessage message);
}
