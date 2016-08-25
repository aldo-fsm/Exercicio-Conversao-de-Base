package conversor;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.Iterator;

public class ConversorBaseBigDecimal {
	private static final String digitos = "0123456789ABCDEF";

	public static String converter(String numero, int baseOrigem, int baseDestino) {
		
		numero.toUpperCase();
		
		if (baseOrigem >= 2 && baseOrigem <= 16 && baseDestino >= 2 && baseDestino <= 16) {

			if (verificarBase(numero, baseOrigem)) {

				if (baseDestino == baseOrigem) {
					return numero;
				} else if (baseOrigem == 10) {
					return deDecimal(new BigDecimal(numero), baseDestino);
				} else if (baseDestino == 10) {
					return paraDecimal(numero, baseOrigem).toString();
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
	
	public static String converterFracionario(String numero, int baseOrigem, int baseDestino) {

		numero.toUpperCase();
		String[] s;
		s = numero.split(",");
		
		return converter(s[0], baseOrigem, baseDestino) + "." + deDecimalFracionario(paraDecimalFracionario(s[1], baseOrigem),baseDestino);
	}
	
	
	

	private static BigDecimal paraDecimalFracionario(String numero, int baseOrigem) {
		BigDecimal decimal = BigDecimal.ZERO;
		long numeroDigitos = numero.length();
		BigDecimal bigBase = BigDecimal.valueOf(baseOrigem);

		for (int i = 0; i < numeroDigitos; i++) {
			BigDecimal valorDigito = BigDecimal.valueOf(digitos.indexOf(numero.charAt(i)));
			decimal = decimal.add(valorDigito.divide(bigBase.pow((int) (i+1))));
		}

		return decimal;
	}

	private static String deDecimalFracionario(BigDecimal decimal, int baseDestino) {
	
		if (decimal.compareTo(BigDecimal.valueOf(baseDestino)) < 0) {
			return Character.toString(digitos.charAt(decimal.intValue()));
		} else {
			String s1 = decimal.toString();
			String s = (decimal.multiply(BigDecimal.valueOf(baseDestino)).toString());
			int numeroExcedido = 0;
			if(s1.length()<s.length()){
				String local = "";
				for (int i = 0; i < s.length()-s1.length(); i++) {
					local += s1.charAt(i);
				}
				numeroExcedido = Integer.parseInt(local);
			}
			
			if(numeroExcedido == baseDestino-1){
				return numeroExcedido + "";
			}else{

			}
			
		}
		return null;
		
	}

	private static boolean verificarBase(String numero, long base) {
		for (int i = 0; i < numero.length(); i++) {
			if (digitos.indexOf(numero.charAt(i)) >= base) {
				return false;
			}
		}
		return true;
	}

	// parte iterativa
	private static BigDecimal paraDecimal(String numero, int base) {

		BigDecimal decimal = BigDecimal.ZERO;
		long numeroDigitos = numero.length();
		BigDecimal bigBase = BigDecimal.valueOf(base);

		for (int i = 0; i < numeroDigitos; i++) {
			BigDecimal valorDigito = BigDecimal.valueOf(digitos.indexOf(numero.charAt(i)));
			decimal = decimal.add(valorDigito.multiply(bigBase.pow((int) (numeroDigitos - 1 - i))));
		}

		return decimal;
	}

	// parte recursiva
	private static String deDecimal(BigDecimal decimal, int baseDestino) {
		
		if (decimal.compareTo(BigDecimal.valueOf(baseDestino)) < 0) {
			return Character.toString(digitos.charAt(decimal.intValue()));
		} else {
			return deDecimal(decimal.divide(BigDecimal.valueOf(baseDestino), BigDecimal.ROUND_DOWN), baseDestino)
					+ digitos.charAt((decimal.remainder(BigDecimal.valueOf(baseDestino)).intValue())) + "";
		}
	}
}
