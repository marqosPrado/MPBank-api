package br.com.marcosprado.mpbank.repository;

import br.com.marcosprado.mpbank.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface AccountsRepository extends JpaRepository<Accounts, UUID> {

    @Query(value = "SELECT a FROM Accounts a WHERE a.accountSequence = :account")
    Accounts findAllByAccountSequence(@Param("account") String account);

}
