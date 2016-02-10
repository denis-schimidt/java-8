package br.com.elo7.java8.model;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;

import java.util.Arrays;
import java.util.List;

public class Capitulo9_3 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Paulo Silveira", 150, true);
		Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
		Usuario user3 = new Usuario("Guilherme Silveira", 90);
		Usuario user4 = new Usuario("Sergio Lopes", 120);
		Usuario user5 = new Usuario("Adriano Almeida", 100);
		
		List<Usuario> usuarios=
				Arrays.asList(user1, user2, user3, user4, user5);
		
		usuarios.stream()
			.collect( partitioningBy( Usuario::isModerador, mapping(Usuario::getNome, joining(", "))))
			.entrySet()
			.forEach(System.out::println);
	}
}
