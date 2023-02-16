package com.javierburillo.javierburillo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.javierburillo.javierburillo.models.PalabraPorLetras;

@Profile("dificil")
@Repository
public class PalabraDificil implements IPalabraRepo {
	private List<String> history = new ArrayList<>();
	private int Tries = 5;

	private List<PalabraPorLetras> Palabras = List.of(
			new PalabraPorLetras(true, 'm', 0, 0),
			new PalabraPorLetras(true, 'a', 1, 1),
			new PalabraPorLetras(true, 'r', 2, 2),
			new PalabraPorLetras(true, 'c', 3, 3),
			new PalabraPorLetras(true, 'i', 4, 4),
			new PalabraPorLetras(true, 'l', 5, 5),
			new PalabraPorLetras(true, 'l', 6, 6),
			new PalabraPorLetras(true, 'a', 7, 7));

	public int getTries() {
		return Tries;
	}

	public void minusOneTry() {
		this.Tries = this.Tries - 1;
	}

	public List<String> getBefore() {
		return history;
	}

	public List<PalabraPorLetras> getPalabras() {
		return Palabras;
	}
}