package com.javierburillo.javierburillo.services;

import java.util.List;

import com.javierburillo.javierburillo.models.PalabraPorLetras;

public interface IPalabraService {
    public List<PalabraPorLetras> check(String Palabras);

    public List<String> getBefore();

    public String getWordByPos(int pos);

    public int getAttempts();
    
}
