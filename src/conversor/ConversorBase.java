package conversor;

import java.security.InvalidParameterException;

public class ConversorBase {

	private static final String digitos = "0123456789ABCDEF";

	public static String converter(String numero, int baseOrigem, int baseDestino) {

		numero.toUpperCase();

		if (baseOrigem >= 2 && baseOrigem <= 16 && baseDestino >= 2 && baseDestino <= 16) {

			if (verificarBase(numero, baseOrigem)) {

				if (baseDestino == baseOrigem) {
					return numero;
				} else if (baseOrigem == 10) {
					return deDecimal(Integer.parseInt(numero), baseDestino);
				} else if (baseDestino == 10) {
					return Integer.toString(paraDecimal(numero, baseOrigem));
				} else {
					// baseOrigem --> base10 --> baseDestino
					return deDecimal(paraDecimal(numero, baseOrigem), baseDestino);
				}

			} else {
				throw new InvalidParameterException("O numero não está na base informada");
			}
		} else {
			throw new InvalidParameterException("Base invalida");
		}
	}

	private static boolean verificarBase(String numero, int base) {
		for (int i = 0; i < numero.length(); i++) {
			if (digitos.indexOf(numero.charAt(i)) >= base) {
				return false;
			}
		}
		return true;
	}

	// parte iterativa
	private static int paraDecimal(String numero, int base) {

		int decimal = 0;
		int numeroDigitos = numero.length();

		for (int i = 0; i < numeroDigitos; i++) {
			int valorDigito = digitos.indexOf(numero.charAt(i));
			decimal += valorDigito * Math.pow(base, numeroDigitos - 1 - i);
		}

		return decimal;
	}

	// parte recursiva
	private static String deDecimal(int decimal, int baseDestino) {
		if (decimal < baseDestino) {
			return Character.toString(digitos.charAt(decimal));
		} else {
			return deDecimal(decimal / baseDestino, baseDestino) + digitos.charAt(decimal % baseDestino);
		}
	}
}
