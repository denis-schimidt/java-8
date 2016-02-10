package br.com.elo7.java8.model;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class Capitulo7_7 {

	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = Lists.newArrayList( new Usuario("Paulo Silveira", 150, true), new Usuario("Rodrigo Turini", 120), 
				new Usuario("Guilherme Silveira", 190), new Usuario("Dênis Schimidt de Oliveira", 120), new Usuario("Paulo Gabriel", 150) );
		
		usuarios.sort( comparingInt( Usuario::getPontos ).reversed() );
		double total = usuarios.stream()
			.mapToInt( Usuario::getPontos )
			.average()
			.orElse( 0 );
		
		System.out.println( total );
		
		/*List<Usuario> usuarios2 = new ArrayList<>();
		double total1 = usuarios2.stream()
			.mapToInt( Usuario::getPontos )
			.average()
			.orElseThrow( () -> new IllegalArgumentException( "Lista Vazia" ) );
		
		System.out.println( total1 );*/
		
		/*usuarios.stream()
			.mapToInt( Usuario::getPontos )
			.average()
			.ifPresent( System.out::println );*/
		
		long totalLong = usuarios.stream()
			.reduce( 0, (atual, u) -> atual + u.getPontos(), Integer::sum);
		System.out.println( totalLong );
		
/*		usuarios.stream()
			.filter( u -> u.getPontos() > 110 )
			.peek( System.out::println )
			.collect( toList() );*/		
	}
}
