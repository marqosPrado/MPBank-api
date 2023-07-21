package br.com.marcosprado.mpbank.controller;

import br.com.marcosprado.mpbank.DTO.TransactionDTO;
import br.com.marcosprado.mpbank.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionController {

    final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity makeTransaction(@RequestBody @Valid TransactionDTO transactionDTO) {
        return ResponseEntity.ok().body(transactionService.createTransaction(transactionDTO));
    }

}
