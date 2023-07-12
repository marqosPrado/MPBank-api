package br.com.marcosprado.mpbank.DTO;

import br.com.marcosprado.mpbank.model.Accounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositDTO {

    private String account;
    private double balance;

}
