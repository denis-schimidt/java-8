package br.com.elo7.java8.model;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Objects;

import com.google.common.collect.Lists;

public class Capitulo6 {

	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = Lists.newArrayList( new Usuario("Paulo Silveira", 150), new Usuario("Rodrigo Turini", 120), 
				new Usuario("Guilherme Silveira", 190), new Usuario("Dênis Schimidt de Oliveira", 120), new Usuario("Paulo Gabriel", 150) );
		
		usuarios.removeIf( Objects::isNull );
		
		usuarios.sort( comparingInt( Usuario::getPontos ).reversed().thenComparing( 
					   comparing( u-> u.getNome() != null ? u.getNome() : "Z" ) ) );
		
		usuarios.forEach( System.out::println );
	}
}
