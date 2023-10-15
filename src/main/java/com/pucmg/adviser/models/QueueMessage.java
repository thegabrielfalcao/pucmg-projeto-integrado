package com.pucmg.adviser.models;

import com.pucmg.adviser.dtos.ItemDTO;

public class QueueMessage {

    public static class Builder {
        private String transactionId;
        private ItemDTO item;
        private String clientId;

        public Builder withTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder withItem(ItemDTO item) {
            this.item = item;
            return this;
        }

        public Builder withClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public QueueMessage build() {
            QueueMessage queueMessage = new QueueMessage();
            queueMessage.setTransactionId(transactionId);
            queueMessage.setItem(item);
            queueMessage.setClientId(clientId);

            return queueMessage;
        }


    }

    private String transactionId;
    private ItemDTO item;
    private String clientId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
