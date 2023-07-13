package br.com.marcosprado.mpbank.controller;

import br.com.marcosprado.mpbank.model.Customer;
import br.com.marcosprado.mpbank.service.CustomerService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustumer(@RequestBody @Valid Customer customer) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomerAccount(customer));

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public List<Customer> listCustumer() {
        return customerService.findAll();
    }


}
