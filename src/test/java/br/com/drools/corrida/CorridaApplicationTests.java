package br.com.drools.corrida;
import br.com.drools.corrida.model.Corrida;
import br.com.drools.corrida.model.Tarifa;
import br.com.drools.corrida.service.CorridaService;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CorridaApplicationTests {
    @Autowired
    private CorridaService corridaService;

    /* DRL */

    @Test
    public void whenCorridaDiurnaComDistanciaMaiorQue20QuilometrosDRL() {
        Corrida corrida = new Corrida();
        corrida.setNoturna(false);
        corrida.setDistanciaPercorrida(25L);
        Tarifa tarifa = corridaService.calcularDRL(corrida);

        assertEquals(50l, tarifa.getValor());
        assertEquals(0l, tarifa.getAdicionalNoturno());
    }

    @Test
    public void whenCorridaNoturnaComDistanciaMaiorQue100QuilometrosDRL() {
        Corrida corrida = new Corrida();
        corrida.setNoturna(true);
        corrida.setDistanciaPercorrida(110L);
        Tarifa tarifa = corridaService.calcularDRL(corrida);

        assertEquals(250l, tarifa.getValor());
        assertEquals(50l, tarifa.getAdicionalNoturno());
    }

    @Test
    public void whenCorridaDiurnaComDistanciaMenorQue20QuilometrosDRL() {
        Corrida corrida = new Corrida();
        corrida.setNoturna(false);
        corrida.setDistanciaPercorrida(19L);
        Tarifa tarifa = corridaService.calcularDRL(corrida);

        assertEquals(30l, tarifa.getValor());
        assertEquals(0l, tarifa.getAdicionalNoturno());
    }

    /* Tabela de decisao */

    @Test
    public void whenCorridaDiurnaComDistanciaMaiorQue20QuilometrosDT() {
        Corrida corrida = new Corrida();
        corrida.setNoturna(false);
        corrida.setDistanciaPercorrida(25L);
        Tarifa tarifa = corridaService.calcularDT(corrida);

        assertEquals(50l, tarifa.getValor());
        assertEquals(0l, tarifa.getAdicionalNoturno());
    }


    @Test
    public void whenCorridaNoturnaComDistanciaMaiorQue100QuilometrosDT() {
        Corrida corrida = new Corrida();
        corrida.setNoturna(true);
        corrida.setDistanciaPercorrida(110L);
        Tarifa tarifa = corridaService.calcularDT(corrida);

        assertEquals(250l, tarifa.getValor());
        assertEquals(50l, tarifa.getAdicionalNoturno());
    }

    @Test
    public void whenCorridaDiurnaComDistanciaMenorQue20QuilometrosDT() {
        Corrida corrida = new Corrida();
        corrida.setNoturna(false);
        corrida.setDistanciaPercorrida(19L);
        Tarifa tarifa = corridaService.calcularDT(corrida);

        assertEquals(30l, tarifa.getValor());
        assertEquals(0l, tarifa.getAdicionalNoturno());
    }

    /* Compilacao da tabela de decisao */

    @Test
    public void compileDT(){
        String path = "src/main/resources/rules/CORRIDA_RULE.xls";
        File dtf = new File(  path);
        InputStream is;
        try {
            is = new FileInputStream( dtf );
            SpreadsheetCompiler ssComp = new SpreadsheetCompiler();
            String s = ssComp.compile( is, InputType.XLS );
            System.out.println( "=== Inicio da geracao do DRL ===" );
            System.out.println( s );
            System.out.println( "=== Fim da geracao do DRL ===" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
