package br.com.marcosprado.mpbank.service;

import br.com.marcosprado.mpbank.model.Accounts;
import br.com.marcosprado.mpbank.model.Customer;
import br.com.marcosprado.mpbank.repository.AccountsRepository;
import br.com.marcosprado.mpbank.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;

    final AccountsRepository accountsRepository;

    final AccountService accountService;

    public CustomerService(CustomerRepository customerRepository, AccountsRepository accountsRepository, AccountService accountService) {
        this.customerRepository = customerRepository;
        this.accountsRepository = accountsRepository;
        this.accountService = accountService;
    }

    private Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer createCustomerAccount(Customer customer) {
        Accounts accounts = new Accounts();
        accounts.setCustomer(customer);
        accounts.setAccountSequence(accountService.createAccountSequence());
        accounts.setCreated_at(LocalDateTime.now());
        accountService.saveAccount(accounts);

        return save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
