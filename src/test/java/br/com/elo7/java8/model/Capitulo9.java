package br.com.elo7.java8.model;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class Capitulo9 {

	public static void main(String[] args) throws IOException {
		Map<Path, List<String>> mapArquivos = Files.list(Paths.get("C:/Users/Denis/Documents"))
			.filter( p-> p.toString().endsWith(".xml"))
			.collect( toMap(Function.identity(), p -> lines(p).collect( toList() ) ) );
		
		mapArquivos.entrySet().forEach(System.out::println);
	}
	
	private static Stream<String> lines(Path p){

		Stream<String> response = null;
		
		try {
			response=Files.lines(p);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return response;
	}
}
