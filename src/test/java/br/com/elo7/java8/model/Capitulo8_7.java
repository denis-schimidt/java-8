package br.com.elo7.java8.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Capitulo8_7 {

	public static void main(String[] args) throws IOException {
		Files.list(Paths.get("C:/Users/Denis/Documents"))
			.filter( f-> f.toString().endsWith(".xml"))
			.flatMap( Capitulo8_7::lines )
			.flatMapToInt( f-> f.chars() )
			.forEach( System.out::println );
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
