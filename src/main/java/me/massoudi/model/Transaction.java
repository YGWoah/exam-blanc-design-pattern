package me.massoudi.model;

import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private long amount;
    private TransactionType transactionType;

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.amount = builder.amount;
        this.transactionType = builder.transactionType;
    }

    public TransactionType getType() {
        return this.transactionType;
    }

    public long getAmount() {
        return this.amount;
    }

    public static class Builder {
        private String id;
        private Date date;
        private long amount;
        private TransactionType transactionType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder amount(long amount) {
            this.amount = amount;
            return this;
        }

        public Builder transactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }


    @Override
    public String toString() {
        return this.id + " " + this.date + " " + this.amount + " " + this.transactionType;
    }
}
