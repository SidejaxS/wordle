package com.javierburillo.javierburillo.repositories;

import java.util.List;

import com.javierburillo.javierburillo.models.PalabraPorLetras;

public interface IPalabraRepo {
    public List<String> getBefore();

    public int getTries();

    public void minusOneTry();

    List<PalabraPorLetras> getPalabras();

    public void setPalabras(String string);

    public void setTries(int i);
}
