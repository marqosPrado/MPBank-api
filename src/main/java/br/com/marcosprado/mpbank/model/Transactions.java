//package br.com.marcosprado.mpbank.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//import java.util.UUID;
//
//@Data
//@Entity
//@AllArgsConstructor
//@Table(name = "transactions")
//public class Transactions {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID transaction_id;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "from_account_id")
//    private Accounts from_account_id;
//
//    private Accounts to_account_id;
//
//}
