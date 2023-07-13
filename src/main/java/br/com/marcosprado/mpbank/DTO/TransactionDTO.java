package br.com.marcosprado.mpbank.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    @NotBlank
    private String from_account;

    @NotBlank
    private String to_account;

    @NotBlank
    private double amount;

}
