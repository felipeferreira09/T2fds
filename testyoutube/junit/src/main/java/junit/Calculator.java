package junit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Classe utilitária para calcular a próxima data.
 */
public class Calculator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final LocalDate MIN_DATE = LocalDate.of(1600, 1, 1);
    private static final LocalDate MAX_DATE = LocalDate.of(9998, 12, 31);
    private static final int DATE_LENGTH = 10;
    private static final int FIRST_SEPARATOR_INDEX = 2;
    private static final int SECOND_SEPARATOR_INDEX = 5;

    private Calculator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Calcula a próxima data a partir de uma data de entrada no formato dd/MM/yyyy.
     *
     * @param input a data de entrada
     * @return a próxima data ou uma mensagem de erro
     */
    public static String calculaProximaData(String input) {
        if (!isValidLength(input)) {
            return "ERRO: tamanho invalido.";
        } else if (!isDigitsOnly(input)) {
            return "ERRO: nao utilizou digito.";
        } else if (!containsCorrectSeparators(input)) {
            return "ERRO: nao utilizou '/'.";
        } else {
            try {
                LocalDate date = LocalDate.parse(input, DATE_FORMATTER);

                if (date.isBefore(MIN_DATE) || date.isAfter(MAX_DATE)) {
                    return "ERRO: data invalida.";
                } else {
                    LocalDate nextDate = date.plusDays(1);
                    return "Data seguinte: " + nextDate.format(DATE_FORMATTER);
                }
            } catch (DateTimeParseException e) {
                return "ERRO: data invalida.";
            }
        }
    }

    private static boolean isValidLength(String date) {
        return date.length() == DATE_LENGTH;
    }

    private static boolean isDigitsOnly(String date) {
        for (int i = 0; i < date.length(); i++) {
            if (i == FIRST_SEPARATOR_INDEX || i == SECOND_SEPARATOR_INDEX) {
                if (date.charAt(i) != '/') {
                    return false;
                }
            } else if (!Character.isDigit(date.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsCorrectSeparators(String date) {
        return date.charAt(FIRST_SEPARATOR_INDEX) == '/' && date.charAt(SECOND_SEPARATOR_INDEX) == '/';
    }
}