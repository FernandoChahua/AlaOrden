package com.alaorden.service.impl;

import com.alaorden.model.Transaction;
import com.alaorden.repository.TransactionRepository;
import com.alaorden.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
