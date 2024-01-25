package org.example;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juego {
    private static final int TAMANIO_MAPA = 30;
    private char[][] mapa = new char[TAMANIO_MAPA][TAMANIO_MAPA];
    private Jugador jugador;
    private Enemigo[] enemigos;
    private int movimientosJugador = 0;
    ObservableList<String> Movimientos = FXCollections.observableArrayList();

    public Juego() {
        this.jugador = new Jugador();
        this.enemigos = new Enemigo[]{new Enemigo(), new Enemigo(), new Enemigo()};
        inicializarMapa();
        for (Enemigo enemigo : enemigos) {
            this.Movimientos.addListener(enemigo);
        }
    }

    private void inicializarMapa() {
        for (int i = 0; i < TAMANIO_MAPA; i++) {
            for (int j = 0; j < TAMANIO_MAPA; j++) {
                mapa[i][j] = '.';
            }
        }
    }

    private void actualizarMapa() {
        inicializarMapa();
        mapa[jugador.getPosicionY()][jugador.getPosicionX()] = 'J';
        for (Enemigo enemigo : enemigos) {
            mapa[enemigo.getPosicionY()][enemigo.getPosicionX()] = 'E';
        }
    }

    private void imprimirMapa() {
        for (int i = 0; i < TAMANIO_MAPA; i++) {
            for (int j = 0; j < TAMANIO_MAPA; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mostrarCoordenadas() {
        imprimirMensaje("Jugador: (" + jugador.getPosicionX() + ", " + jugador.getPosicionY() + ")");
        for (Enemigo enemigo : enemigos) {
            imprimirMensaje("Enemigo: (" + enemigo.getPosicionX() + ", " + enemigo.getPosicionY() + ")");
        }
    }

    public void jugar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String movimiento;
        imprimirMensaje("Posiciones Iniciales:");
        mostrarCoordenadas();
        actualizarMapa();
        imprimirMapa();

        do {
            imprimirMensaje("Haz un movimiento: a,s,d,w o");
            movimiento = br.readLine();
            this.moverJugador(movimiento);
            this.Movimientos.add(jugador.getPosicionX() + "," + jugador.getPosicionY());

            actualizarMapa();
            imprimirMapa();

            movimientosJugador++;
            mostrarCoordenadas();
        } while (!this.comprobarMuerte());

        imprimirMensaje("Has muerto en " + movimientosJugador + " movimientos");
    }

    public boolean comprobarMuerte() {
        for (Enemigo enemigo : enemigos) {
            if (jugador.getPosicionX() == enemigo.getPosicionX() && jugador.getPosicionY() == enemigo.getPosicionY()) {
                return true;
            }
        }
        return false;
    }

    public void moverJugador(String movimiento) {
        int dx = 0, dy = 0;
        switch (movimiento) {
            case "a": dx = -1; break;
            case "d": dx = 1; break;
            case "w": dy = -1; break;
            case "s": dy = 1; break;
            case "exit": System.exit(0);
            default: imprimirMensaje("Movimiento invalido");
        }

        jugador.setPosicionX(Math.min(Math.max(jugador.getPosicionX() + dx, 0), TAMANIO_MAPA - 1));
        jugador.setPosicionY(Math.min(Math.max(jugador.getPosicionY() + dy, 0), TAMANIO_MAPA - 1));
    }

    private void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
