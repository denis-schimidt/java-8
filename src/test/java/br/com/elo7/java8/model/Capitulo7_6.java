package br.com.elo7.java8.model;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class Capitulo7_6 {

	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = Lists.newArrayList( new Usuario("Paulo Silveira", 150, true), new Usuario("Rodrigo Turini", 120), 
				new Usuario("Guilherme Silveira", 190), new Usuario("Dênis Schimidt de Oliveira", 120), new Usuario("Paulo Gabriel", 150) );
		
		usuarios.sort( comparingInt( Usuario::getPontos ).reversed() );

		int total = usuarios.stream()
			.mapToInt( Usuario::getPontos )
			.sum();
		
		System.out.println( total );
		
		int[] pontos = usuarios.stream()
				.mapToInt( Usuario::getPontos )
				.toArray();

		for (int ponto : pontos) {
			System.out.println(ponto);
		}
		
		List<Integer> listaPontos = usuarios.stream()
			.map( Usuario::getPontos )
			.collect( toList() );

		listaPontos.forEach( System.out::println );
	}
}
