package com.javierburillo.javierburillo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.javierburillo.javierburillo.models.PalabraPorLetras;

@Profile("facil")
@Repository
public class PalabraFacil implements IPalabraRepo {
	private List<String> history = new ArrayList<>();
	private int Tries = 20;
	
	
	

	private List<PalabraPorLetras> Palabras = List.of(
			new PalabraPorLetras(true, 'p', 0, 0),
			new PalabraPorLetras(true, 'i', 1, 1),
			new PalabraPorLetras(true, 's', 2, 2));

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

	@Override
	public void setPalabras(String string) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setPalabras'");
	}

	@Override
	public void setTries(int i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setTries'");
	}
}
