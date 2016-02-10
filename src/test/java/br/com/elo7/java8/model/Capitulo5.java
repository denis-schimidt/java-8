package br.com.elo7.java8.model;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

public class Capitulo5 {

	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = Lists.newArrayList( new Usuario("Paulo Silveira", 150), new Usuario("Rodrigo Turini", 120), 
				new Usuario("Guilherme Silveira", 190), new Usuario("Dênis Schimidt de Oliveira", 120) );
		
		usuarios.sort( comparing( u -> u.getNome() != null ? "" : u.getNome() ) );
		
		usuarios.forEach( System.out::println );
		
		List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");
		palavras.sort( naturalOrder() );
		palavras.forEach( System.out::println );
		
		usuarios.sort( comparingInt( u-> u.getPontos() ) );
		usuarios.forEach( System.out::println );
	}
}
