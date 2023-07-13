package br.com.marcosprado.mpbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marcosprado.mpbank.model.Accounts;
import br.com.marcosprado.mpbank.model.Transactions;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, UUID>{
    
    @Query(value = "SELECT a FROM Accounts a WHERE a.accountSequence = :account")
    Accounts findAllByAccountSequence(@Param("account") String account);
}

/*
    - criar um DTO para receber a conta de quem vai enviar e aconta de quem vai receber;
    - validar se a conta de quem vai enviar e receber existe e se está ativa;
    - validar o amunt da conta
 */