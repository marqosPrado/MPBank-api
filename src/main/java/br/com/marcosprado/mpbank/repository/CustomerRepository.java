package br.com.marcosprado.mpbank.repository;

import br.com.marcosprado.mpbank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

//    Customer findAllByCpf_id(Customer customer);

}
