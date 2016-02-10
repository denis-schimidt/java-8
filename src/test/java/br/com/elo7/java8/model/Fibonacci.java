package br.com.elo7.java8.model;

import java.util.function.IntSupplier;

public class Fibonacci implements IntSupplier {
	private int atual = 0;
	private int proximo = 1;
	private boolean primeiraResposta=true;
	
	@Override
	public int getAsInt() {
		
		if(!primeiraResposta){
			atual=proximo-atual;
			proximo+=atual;
			return atual;

		}else{
			primeiraResposta=false;
			return 0;
		}
	}
}
