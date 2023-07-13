package br.com.marcosprado.mpbank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transaction_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_account_id")
    private Accounts from_account_id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Accounts to_account_id;

    private LocalDateTime data_issue;

    @NotBlank
    private double amount;

}
