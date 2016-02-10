package br.com.elo7.java8.model;

import java.util.Arrays;
import java.util.List;

public class Capitulo2 {

	public static void main(String[] args) {
		List<Usuario> usuarios = Arrays.asList( new Usuario("Paulo Silveira", 150), new Usuario("Rodrigo Turini", 120), 
				new Usuario("Guilherme Silveira", 190));
		
		Validador<Usuario> validaUsuario = u -> u.getNome().matches( "[0-9]{5}-[0-9]{3}");
		
		usuarios.forEach( t -> System.out.println( validaUsuario.validar( t ) ) );
	}
}
