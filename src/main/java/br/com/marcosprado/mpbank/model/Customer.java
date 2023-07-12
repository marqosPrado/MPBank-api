package br.com.marcosprado.mpbank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    private String cpf_id;

    @Column(length = 50, nullable = false)
    private String fullName;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 12, nullable = false)
    private String mobileNumber;

}
