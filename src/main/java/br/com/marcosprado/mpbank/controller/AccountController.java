package br.com.marcosprado.mpbank.controller;

import br.com.marcosprado.mpbank.DTO.DepositDTO;
import br.com.marcosprado.mpbank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {

    final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/deposit")
    public ResponseEntity<?> depositAmount(@RequestBody @Valid DepositDTO depositDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.depositAmount(depositDTO));
    }

}
