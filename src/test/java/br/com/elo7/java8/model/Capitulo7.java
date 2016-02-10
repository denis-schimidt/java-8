package br.com.elo7.java8.model;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class Capitulo7 {

	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = Lists.newArrayList( new Usuario("Paulo Silveira", 150, true), new Usuario("Rodrigo Turini", 120), 
				new Usuario("Guilherme Silveira", 190), new Usuario("Dênis Schimidt de Oliveira", 120), new Usuario("Paulo Gabriel", 150) );
		
		usuarios.sort( comparingInt( Usuario::getPontos ).reversed() );
		
		List<Usuario> resultado = usuarios.stream()
			.filter( Usuario::isModerador )
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		resultado.forEach( System.out::println );
		
		List<Usuario> resultado1 = usuarios.stream()
				.filter( Usuario::isModerador )
				.collect( toList() );
			
		resultado1.forEach( System.out::println );
		
		Set<Usuario> resultado2 = usuarios.stream()
				.filter( Usuario::isModerador )
				.collect( Collectors.toCollection( HashSet::new ) );
			
		resultado2.forEach( System.out::println );
	}
}
