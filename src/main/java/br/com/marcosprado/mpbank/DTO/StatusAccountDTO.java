package br.com.marcosprado.mpbank.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusAccountDTO {

    @NotBlank
    private String accountSequence;

}
