package br.com.marcosprado.mpbank.service;

import br.com.marcosprado.mpbank.model.Transactions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.marcosprado.mpbank.DTO.TransactionDTO;
import br.com.marcosprado.mpbank.model.Accounts;
import br.com.marcosprado.mpbank.repository.TransactionRepository;

import java.time.LocalDateTime;

@Service
public class TransactionService {


    final AccountService accountService;
    final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    private boolean validTransaction(Accounts from_account, Accounts to_account, double amount) {
        if(from_account == null || to_account == null) {
            return false;
        }

        if(from_account.getAccountSequence().equals(to_account.getAccountSequence())) {
            return false;
        }

        if(!from_account.isAccount_status() || !to_account.isAccount_status()) {
            return false;
        }

        if(amount <= 0) {
            return false;
        }
        return from_account.getBalance() > 0 && from_account.getBalance() >= amount;
    }

    private Accounts findAllByAccountSequence(String accountSequence) {
        return transactionRepository.findAllByAccountSequence(accountSequence);
    }
    
    public ResponseEntity<?> createTransaction(TransactionDTO transactionDTO) {
        Accounts from_account = this.findAllByAccountSequence(transactionDTO.getFrom_account());
        Accounts to_account = this.findAllByAccountSequence(transactionDTO.getTo_account());
        double amount = transactionDTO.getAmount();

        if (validTransaction(from_account, to_account, amount)) {
            from_account.setBalance(from_account.getBalance() - transactionDTO.getAmount());
            to_account.setBalance(to_account.getBalance() + transactionDTO.getAmount());
            accountService.saveAccount(from_account);
            accountService.saveAccount(to_account);

            Transactions transactions = new Transactions();
            transactions.setFrom_account_id(from_account);
            transactions.setTo_account_id(to_account);
            transactions.setData_issue(LocalDateTime.now());
            transactions.setAmount(amount);
            saveTransactionDetails(transactions);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    private void saveTransactionDetails(Transactions transaction) {
        this.transactionRepository.save(transaction);
    }

}
