package br.com.elo7.java8.model;

import java.util.stream.IntStream;

public class Capitulo8_5 {

	public static void main(String[] args) {
		/*Random random = new Random( 0 );
		IntStream intStream = IntStream.generate( ()-> random.nextInt() );*/
		
		/*intStream
			.limit(2)
			.boxed() 
			.sorted( Comparator.reverseOrder() )
			.forEach( System.out::println );*/
		
		IntStream.generate(new Fibonacci())
			.limit(30)
			//.forEach( System.out::println );
			.filter( f-> f > 100 )
			.findFirst()
			.ifPresent(System.out::println);
	}
}
