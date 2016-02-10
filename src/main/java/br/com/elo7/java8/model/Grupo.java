package br.com.elo7.java8.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Grupo {
	private Set<Usuario> usuarios = new HashSet<>();

	public void add(Usuario u) {
		usuarios.add(u);
	}

	public Set<Usuario> getUsuarios() {
		return Collections.unmodifiableSet(this.usuarios);
	}
}
