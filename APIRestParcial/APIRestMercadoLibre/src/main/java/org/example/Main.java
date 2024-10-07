package org.example;

import org.example.Entidades.Humano;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        System.out.println("funcionando");
//
//        List<String> dnaHumano1 = Arrays.asList(
//                "AAAAGTG",
//                "CAGTGCC",
//                "TGATATG",
//                "GAACTGC",
//                "CCCTTCG",
//                "TGACTTG",
//                "CACTACG"
//        );
//
//        Humano humano2 = Humano.builder()
//                .dna(dnaHumano1)
//                .build();
//
//        boolean rta = humano2.esMutante(humano2.getDna());
//        humano2.setEsMutante(rta);

    }
}