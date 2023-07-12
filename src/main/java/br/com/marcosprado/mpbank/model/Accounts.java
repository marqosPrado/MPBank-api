package br.com.marcosprado.mpbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID account_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private double balance;

    private boolean account_status;

    private LocalDateTime created_at;

    public Accounts() {
        this.balance = 0;
        this.account_status = true;
    }

}
