package org.example;

import javafx.collections.ListChangeListener;
import lombok.Data;

/**
 * Clase que representa a un enemigo en el juego.
 * El enemigo se mueve en el mapa en respuesta a los movimientos del jugador.
 */
@Data
public class Enemigo implements ListChangeListener<String> {

    private static final int TAMANIO_MAPA = 30; // Tamaño del mapa
    private String nombre;
    private int posicionX;
    private int posicionY;

    /**
     * Constructor que inicializa el enemigo con una posición aleatoria en el mapa.
     */
    public Enemigo() {
        this.nombre = "Enemigo";
        this.posicionX = (int) (Math.random() * TAMANIO_MAPA);
        this.posicionY = (int) (Math.random() * TAMANIO_MAPA);}

    /**
     * Método llamado cuando hay cambios en la lista de movimientos del jugador.
     * El enemigo se mueve hacia la última posición conocida del jugador.
     *
     * @param change Información sobre los cambios en la lista de movimientos del jugador.
     */
    @Override
    public void onChanged(Change<? extends String> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                String ultimoMovimiento = change.getList().get(change.getList().size() - 1);
                int[] ultimaPosicionJugador = parsearPosicion(ultimoMovimiento);
                moverHaciaJugador(ultimaPosicionJugador[0], ultimaPosicionJugador[1]);
            }
        }
    }

    /**
     * Parsea la posición del jugador a partir de una cadena de texto.
     *
     * @param posicion Cadena que representa la posición del jugador.
     * @return Un arreglo con la posición X e Y del jugador.
     */
    private int[] parsearPosicion(String posicion) {
        String[] partes = posicion.split(",");
        return new int[]{Integer.parseInt(partes[0]), Integer.parseInt(partes[1])};
    }

    /**
     * Mueve el enemigo hacia la posición del jugador.
     *
     * @param pJugadorX Posición X del jugador.
     * @param pJugadorY Posición Y del jugador.
     */
    private void moverHaciaJugador(int pJugadorX, int pJugadorY) {
        for (int i = 0; i < 2; i++) {
            this.posicionX += Integer.compare(pJugadorX, this.posicionX);
            this.posicionY += Integer.compare(pJugadorY, this.posicionY);
        }
    }
}
