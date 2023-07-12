package br.com.marcosprado.mpbank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @NotBlank
    private String cpf_id;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String fullName;

    @NotBlank
    @Email
    @Column(length = 50, nullable = false)
    private String email;

    @NotBlank
    @NumberFormat
    @Column(length = 12, nullable = false)
    private String mobileNumber;

}
