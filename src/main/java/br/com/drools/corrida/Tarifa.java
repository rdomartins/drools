package br.com.drools.corrida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarifa {
    private Long adicionalNoturno;
    private Long valor;
}