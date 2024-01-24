package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Subject {
    private List<Observer> observers; // Lista de observadores
    private int x, y; // Coordenadas del jugador

    // Constructor
    public Jugador(int x, int y) {
        this.observers = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    // Métodos de Subject
    @Override
    public void agregar(Observer o) {
        observers.add(o);
    }

    @Override
    public void eliminar(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notificar() {
        for (Observer observer : observers) {
            observer.actualizar(this.x, this.y);
        }
    }

    // Métodos de movimiento
    public void mover(char direccion) {
        switch (direccion) {
            case 'a': // izquierda
                this.x -= 1;
                break;
            case 'd': // derecha
                this.x += 1;
                break;
            case 'w': // arriba
                this.y -= 1;
                break;
            case 's': // abajo
                this.y += 1;
                break;
            default:
                System.out.println("Dirección no válida");
        }
        notificar(); // Notifica a los observadores después de cada movimiento
    }

    // Getters para las coordenadas
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
