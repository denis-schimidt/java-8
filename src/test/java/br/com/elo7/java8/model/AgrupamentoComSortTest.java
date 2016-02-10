package br.com.elo7.java8.model;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class AgrupamentoComSortTest {
	
	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		
		String[] nomes = {"Paulo Silveira","Rodrigo Turini","Guilherme Silveira","Sergio Lopes","Adriano Almeida",
				"Erich", "Mario", "Dênis Schimidt", "Harada", "Leonardo Wolfer"}; 
		
		List<Usuario> usuarios = IntStream.range(0, 1_000)
			.mapToObj(i-> new Usuario(nomes[i%10], (int) (Math.random() * 10), i%2==0))
			.collect(toList());

		Supplier<TreeSet<String>> supplier = ()-> new TreeSet<String>((u1, u2)-> u1.compareTo(u2));
		
		Map<Integer, TreeSet<String>> mapaUsuarios = usuarios.stream()
			.collect(groupingBy(Usuario::getPontos, mapping(Usuario::getNome, toCollection(supplier))));
					
		mapaUsuarios.entrySet()
			.forEach(System.out::println);
		
		long tempoFinal = System.currentTimeMillis();	
		
		System.out.println(tempoFinal-tempoInicial);
	}
}
