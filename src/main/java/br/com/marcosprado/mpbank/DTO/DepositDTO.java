package br.com.marcosprado.mpbank.DTO;

import br.com.marcosprado.mpbank.model.Accounts;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositDTO {

    @NotBlank
    private String account;

    @NotBlank
    private double balance;

}
