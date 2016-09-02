package testes;

import conversor.ConversorBaseBigDecimal;

public class Teste {
	public static void main(String[] args) {
		String numero = "10101,101011";
		int bi = 2;
		int bf = 7;
		//System.out.println(ConversorBaseBigDecimal.converterFracionario(numero, bi, bf,100));
		System.out.println(ConversorBaseBigDecimal.converterFracionario("a", 16, 10,12));
	
	}
}
