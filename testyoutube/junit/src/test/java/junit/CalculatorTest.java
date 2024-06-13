package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testCalculaProximaDataValidDate() {
        assertEquals("Data seguinte: 02/01/2020", Calculator.calculaProximaData("01/01/2020"));
    }

    @Test
    public void testCalculaProximaDataInvalidDate() {
        assertEquals("ERRO: data invalida.", Calculator.calculaProximaData("32/01/2020"));
    }

    @Test
    public void testCalculaProximaDataInvalidLength() {
        assertEquals("ERRO: tamanho invalido.", Calculator.calculaProximaData("01/01/20"));
    }

    @Test
    public void testCalculaProximaDataNonDigit() {
        assertEquals("ERRO: nao utilizou digito.", Calculator.calculaProximaData("01/0A/2020"));
    }

    @Test
    public void testCalculaProximaDataMissingSeparator() {
        assertEquals("ERRO: nao utilizou '/'.", Calculator.calculaProximaData("01012020"));
    }
}