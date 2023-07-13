package br.com.marcosprado.mpbank.service;

import br.com.marcosprado.mpbank.DTO.DepositDTO;
import br.com.marcosprado.mpbank.model.Accounts;
import br.com.marcosprado.mpbank.repository.AccountsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AccountService {

    final AccountsRepository accountsRepository;

    public AccountService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }


    public String generateAccount() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public String createAccountSequence() {
        Random random = new Random();
        char[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9'};
        StringBuilder fix = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(characters.length);
            char someChar = characters[randomIndex];
            fix.append(someChar);
        }

        StringBuilder sulfix = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            int randomIndex = random.nextInt(characters.length);
            char someChar = characters[randomIndex];
            sulfix.append(someChar);
        }
        return fix + "-" + sulfix;
    }

    public ResponseEntity<?> depositAmount(DepositDTO depositDTO) {
        if(depositDTO.getBalance() <= 0) {
            return ResponseEntity.badRequest().body("Invalid Value");
        }
        try {
            Accounts account = accountsRepository.findAllByAccountSequence(depositDTO.getAccount());
            double balance = depositDTO.getBalance();

            if (account != null) {
                if (account.isAccount_status()) {
                    double currentBalance = account.getBalance();
                    double newCurrentBalance = currentBalance + balance;

                    account.setBalance(newCurrentBalance);
                    accountsRepository.save(account);
                    return ResponseEntity.status(HttpStatus.FOUND).build();
                }
            }
        } catch (HttpClientErrorException.NotFound exception) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Invalid");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Invalid");
    }

    public ResponseEntity<Accounts> deactivateAccount(String accountSequence) {
        Accounts account = this.findAllByAccountSequence(accountSequence);

        account.setAccount_status(false);
        saveAccount(account);
        return ResponseEntity.ok().body(account);
    }

    public ResponseEntity<Accounts> activateAccount(String accountSequence) {
        Accounts account = this.findAllByAccountSequence(accountSequence);

        account.setAccount_status(true);
        saveAccount(account);
        return ResponseEntity.ok().body(account);
    }

    private Accounts findAllByAccountSequence(String accountSequence) {
        return accountsRepository.findAllByAccountSequence(accountSequence);
    }

    public void saveAccount(Accounts account) {
        accountsRepository.save(account);
    }


    public List<Accounts> findAll() {
        return accountsRepository.findAll();
    }
}
