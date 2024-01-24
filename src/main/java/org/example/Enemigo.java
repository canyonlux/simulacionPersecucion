package org.example;

public class Enemigo implements Observer {
    private int x, y; // Coordenadas del enemigo

    // Constructor
    public Enemigo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método de actualización implementado de la interfaz Observer
    @Override
    public void actualizar(int jugadorX, int jugadorY) {
        // Moverse hacia la posición del jugador
        // El enemigo se mueve dos posiciones en la dirección del jugador

        // Movimiento en el eje X
        if (this.x < jugadorX) {
            this.x += Math.min(1, jugadorX - this.x); // Moverse hacia la derecha
        } else if (this.x > jugadorX) {
            this.x -= Math.min(1, this.x - jugadorX); // Moverse hacia la izquierda
        }

        // Movimiento en el eje Y
        if (this.y < jugadorY) {
            this.y += Math.min(1, jugadorY - this.y); // Moverse hacia abajo
        } else if (this.y > jugadorY) {
            this.y -= Math.min(1, this.y - jugadorY); // Moverse hacia arriba
        }

        mostrarPosicion(); // Mostrar la posición actual del enemigo
    }

    // Getters para las coordenadas
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Método para mostrar la posición actual del enemigo
    public void mostrarPosicion() {
        System.out.println("El enemigo se ha movido a la posición (" + x + "," + y + ").");
    }
}
