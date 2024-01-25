package org.example;

import lombok.Data;

/**
 * Clase que representa al jugador en el juego.
 * Gestiona la posición del jugador y verifica los límites del mapa.
 */
@Data
public class Jugador {
    private static final int TAMANIO_MAPA = 30; // Tamaño del mapa para posiciones
    private String nombre;
    private int posicionX;
    private int posicionY;

    /**
     * Constructor que inicializa el jugador con un nombre y una posición aleatoria en el mapa.
     */
    public Jugador() {
        this.nombre = "Jugador";
        this.posicionX = (int) (Math.random() * TAMANIO_MAPA);
        this.posicionY = (int) (Math.random() * TAMANIO_MAPA);
    }

}
