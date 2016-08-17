package conversor;

public class ConversorBase {

	private static final String digitos = "0123456789ABCDEF";

	public String converter(String numero, int baseOrigem, int baseDestino) {
		numero.toUpperCase();

		return null;
	}

	private int paraDecimal(String numero, int base) {

		int decimal = 0;
		int numeroDigitos = numero.length();

		for (int i = 0; i < numeroDigitos; i++) {
			int valorDigito = digitos.indexOf(numero.charAt(i));
			decimal += valorDigito * Math.pow(base, numeroDigitos - 1 - i);
		}
		return decimal;
	}
}
