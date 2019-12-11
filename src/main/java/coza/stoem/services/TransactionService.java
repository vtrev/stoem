package coza.stoem.services;

import coza.stoem.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private List<Transaction> transactions = new ArrayList();

    public List getTransactions() {
        return transactions;
    }

    public void capture(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
