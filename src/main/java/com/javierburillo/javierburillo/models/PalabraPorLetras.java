package com.javierburillo.javierburillo.models;

import org.springframework.stereotype.Component;

@Component
public class PalabraPorLetras {
    private char palabraPorLetras;
    private boolean correcto;
    private int posicion;
    private int posicionCorrecta;

    public PalabraPorLetras() {
    }

    public PalabraPorLetras(boolean correcto, char palabraPorLetras, int posicion, int posicionCorrecta) {
        this.palabraPorLetras = palabraPorLetras;
        this.posicion = posicion;
        this.correcto = true;
        this.posicionCorrecta = posicionCorrecta;
    }

    public PalabraPorLetras(boolean correcto, char palabraPorLetras, int posicion) {
        this.correcto = false;
        this.palabraPorLetras = palabraPorLetras;
        this.posicion = posicion;
        this.posicionCorrecta = -1;
    }

    public char getPalabraPorLetras() {
        return palabraPorLetras;
    }

    public void setPalabraPorLetras(char palabraPorLetras) {
        this.palabraPorLetras = palabraPorLetras;
    }

    public int getposicion() {
        return posicion;
    }

    public void setposicion(int posicion) {
        this.posicion = posicion;
    }

    public int getposicionCorrecta() {
        return posicionCorrecta;
    }

    public void setposicionCorrecta(int posicionCorrecta) {
        this.posicionCorrecta = posicionCorrecta;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }
}
