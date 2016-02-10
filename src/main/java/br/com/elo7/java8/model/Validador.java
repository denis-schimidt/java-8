package br.com.elo7.java8.model;

import java.util.Objects;

@FunctionalInterface
public interface Validador<T> {

	public boolean validar( T objeto );
	
	default boolean isNull( T objeto ){
		return Objects.isNull( objeto );
	}
}
