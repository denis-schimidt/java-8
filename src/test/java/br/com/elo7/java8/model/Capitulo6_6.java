package br.com.elo7.java8.model;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

public class Capitulo6_6 {

	public static void main(String[] args) {
		Supplier<Usuario> supplier = Usuario::new;
		Usuario usuario = supplier.get();
		System.out.println( usuario );
		
		Function<String, Usuario> function = Usuario::new;
		System.out.println( function.apply( "Denis" ) );
		
		BiFunction<String, Integer, Usuario> biFunction = Usuario::new;
		Usuario usuario2 = biFunction.apply( "Denis", 37);
		System.out.println( usuario2 );

		IntFunction<int[]> intFunction = int[]::new;
		int[] arrayInt = intFunction.apply( 10 );
		System.out.println( arrayInt.length );
		
		BiFunction<Integer, Integer, Integer> maximoFunc = Math::max;
		int maximo1 = maximoFunc.apply(10, 20);
		System.out.println( maximo1 );
		
		IntBinaryOperator maximo2Fun = Math::max;
		int maximo2 = maximo2Fun.applyAsInt(10, 20);
		System.out.println( maximo2 );
		
		ToIntBiFunction<Integer, Integer> maximo3Func = Math::max; 
		int maximo3 = maximo3Func.applyAsInt(10, 20);
		System.out.println(maximo3);
	}
}
