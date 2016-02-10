package br.com.elo7.java8.model;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;

public class GrupoTest {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Paulo Silveira", 150, true);
		Usuario user2 = new Usuario("Rodrigo Turini", 120); 
		Usuario user3 =	new Usuario("Guilherme Silveira", 190);
		
		Grupo englishSpeakers = new Grupo();
		englishSpeakers.add(user1);
		englishSpeakers.add(user2);
		Grupo spanishSpeakers = new Grupo();
		spanishSpeakers.add(user2);
		spanishSpeakers.add(user3);

		List<Grupo> groups = Arrays.asList(englishSpeakers, spanishSpeakers);
		
		groups.stream()
			.flatMap(g-> g.getUsuarios().stream())
			.collect(toSet())
			.forEach(System.out::println);
	}
}
