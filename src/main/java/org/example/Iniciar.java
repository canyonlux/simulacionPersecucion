package org.example;

public class Iniciar {
    public static void main(String[] args) {
        Juego juego = new Juego();
        try {
            juego.jugar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}