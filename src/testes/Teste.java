package testes;

import conversor.ConversorBase;
import conversor.ConversorBaseBigDecimal;

public class Teste {
	public static void main(String[] args) {
		String numero = "51245680";
		int bi = 10;
		int bf = 2;
		System.out.println(ConversorBase.converter(numero,bi,bf));
		System.out.println(ConversorBaseBigDecimal.converter(numero,bi,bf));
	}
}
