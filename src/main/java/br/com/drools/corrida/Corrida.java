package br.com.drools.corrida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Corrida {
    private Boolean noturna;
    private Long distanciaPercorrida;
}