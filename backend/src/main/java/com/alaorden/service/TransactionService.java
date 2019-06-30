package com.alaorden.service;

import com.alaorden.model.Transaction;
import com.alaorden.repository.TransactionRepository;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
}
