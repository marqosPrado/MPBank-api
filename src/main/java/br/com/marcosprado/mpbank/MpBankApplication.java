package br.com.marcosprado.mpbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MpBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpBankApplication.class, args);
    }

}
