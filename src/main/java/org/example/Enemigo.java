package org.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Enemigo implements Observer  {
    private IntegerProperty x = new SimpleIntegerProperty();
    private IntegerProperty y = new SimpleIntegerProperty();

    // Constructor
    public Enemigo(int x, int y) {
        this.x.set(x);
        this.y.set(y);
    }
    public int getX() {
        return x.get();
    }

    public int getY() {
        return y.get();
    }
    // Método de actualización implementado de la interfaz Observer
    @Override
    public void actualizar(int jugadorX, int jugadorY) {
        // Movimiento en el eje X
        if (this.x.get() < jugadorX) {
            this.x.set(this.x.get() + Math.min(2, jugadorX - this.x.get())); // Moverse hacia la derecha
        } else if (this.x.get() > jugadorX) {
            this.x.set(this.x.get() - Math.min(2, this.x.get() - jugadorX)); // Moverse hacia la izquierda
        }

        // Movimiento en el eje Y
        if (this.y.get() < jugadorY) {
            this.y.set(this.y.get() + Math.min(2, jugadorY - this.y.get())); // Moverse hacia abajo
        } else if (this.y.get() > jugadorY) {
            this.y.set(this.y.get() - Math.min(2, this.y.get() - jugadorY)); // Moverse hacia arriba
        }

        mostrarPosicion(); // Mostrar la posición actual del enemigo
    }


    // Getters para las propiedades x y y
    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    // Método para mostrar la posición actual del enemigo
    public void mostrarPosicion() {
        System.out.println("El enemigo se ha movido a la posición (" + x.get() + "," + y.get() + ").");
    }
}