package br.com.marcosprado.mpbank.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.marcosprado.mpbank.DTO.TransactionDTO;
import br.com.marcosprado.mpbank.model.Accounts;
import br.com.marcosprado.mpbank.repository.TransactionRepository;

@Service
public class TransactionService {

    final AccountService accountService;
    final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    private boolean validTransaction(Accounts from_account, Accounts to_account, double amount) {
        if(from_account != null && to_account != null) {
            if(from_account.isAccount_status() && to_account.isAccount_status()) {
                if(amount > 0) {
                    return from_account.getBalance() > 0 && from_account.getBalance() >= amount;
                }
            }
        }
        return false;
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
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
