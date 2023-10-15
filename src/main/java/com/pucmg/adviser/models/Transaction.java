package com.pucmg.adviser.models;

import com.pucmg.adviser.enums.Status;

public class Transaction {

    public static class Builder {
        private Status status;
        private String transactionId;
        private Long itemId;
        private String clientId;

        public Builder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder withTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder withItemId(Long itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder withClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Transaction build() {
            Transaction transaction = new Transaction();
            transaction.setItemId(itemId);
            transaction.setStatus(status);
            transaction.setClientId(clientId);
            transaction.setTransactionId(transactionId);

            return transaction;
        }
    }
    private Status status;
    private String transactionId;
    private Long itemId;
    private String clientId;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
