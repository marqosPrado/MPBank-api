package br.com.marcosprado.mpbank.controller;

import br.com.marcosprado.mpbank.DTO.StatusAccountDTO;
import br.com.marcosprado.mpbank.DTO.DepositDTO;
import br.com.marcosprado.mpbank.model.Accounts;
import br.com.marcosprado.mpbank.service.AccountService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api")
public class AccountController {

    final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/deposit")
    public ResponseEntity<?> depositAmount(@RequestBody @Valid DepositDTO depositDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(accountService.depositAmount(depositDTO));

        } catch (HttpClientErrorException.NotFound exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
        }
    }

    @GetMapping("/account")
    public List<Accounts> listAccounts() {
        return accountService.findAll();
    }

    @DeleteMapping("/account")
    public ResponseEntity<Accounts> deleteAccount(@RequestBody StatusAccountDTO statusAccountDTO) {
        return accountService.deactivateAccount(statusAccountDTO.getAccountSequence());
    }

    @PutMapping("/account")
    public ResponseEntity<Accounts> activateAccount(@RequestBody StatusAccountDTO statusAccountDTO) {
        return accountService.activateAccount(statusAccountDTO.getAccountSequence());
    }


}
