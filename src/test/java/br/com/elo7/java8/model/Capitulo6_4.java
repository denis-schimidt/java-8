package br.com.elo7.java8.model;

import java.util.function.Consumer;

public class Capitulo6_4 {

	public static void main(String[] args) {

		Usuario rodrigo = new Usuario("Rodrigo Turini", 120);

		Consumer<Usuario> consumer = Usuario::tornaModerador;
		consumer.accept(rodrigo);
		
		System.out.println( rodrigo );
	}
}
