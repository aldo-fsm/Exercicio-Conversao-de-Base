package testes;

import conversor.ConversorBase;
import conversor.ConversorBaseBigDecimal;

public class Teste {
	public static void main(String[] args) {
		String numero = "ABCDEF0,12345";
		int bi = 16;
		int bf = 2;
		System.out.println(ConversorBaseBigDecimal.converterFracionario(numero, bi, bf));
	}
}
