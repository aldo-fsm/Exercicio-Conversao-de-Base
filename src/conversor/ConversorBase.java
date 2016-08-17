package conversor;

public class ConversorBase {

	private static final String digitos = "0123456789ABCDEF";

	public String converter(String numero, int baseOrigem, int baseDestino) {

		numero.toUpperCase();

		if (baseOrigem >= 2 && baseOrigem <= 16 && baseDestino >= 2 && baseDestino <= 16) {

			if (baseDestino == baseOrigem) {
				return numero;
			} else if (baseOrigem == 10) {
				return deDecimal(Integer.parseInt(numero), baseDestino);
			} else if (baseDestino == 10) {
				return Integer.toString(paraDecimal(numero, baseOrigem));
			} else {
				// baseOrigem --> base10 --> baseDestino
				return deDecimal(paraDecimal(numero, baseDestino), baseOrigem);
			}

		}

		return null;
	}

	// parte iterativa
	private int paraDecimal(String numero, int base) {

		int decimal = 0;
		int numeroDigitos = numero.length();

		for (int i = 0; i < numeroDigitos; i++) {
			int valorDigito = digitos.indexOf(numero.charAt(i));
			decimal += valorDigito * Math.pow(base, numeroDigitos - 1 - i);
		}

		return decimal;
	}

	// parte recursiva
	private String deDecimal(int decimal, int baseDestino) {

		return null;
	}
}
