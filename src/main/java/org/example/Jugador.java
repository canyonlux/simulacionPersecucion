package org.example;
import javafx.collections.ListChangeListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Subject {
    private List<Observer> observers; // Lista de observadores
    private IntegerProperty x; // Coordenada x del jugador
    private IntegerProperty y; // Coordenada y del jugador

    // Constructor
    public Jugador(int x, int y) {
        this.observers = new ArrayList<>();
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    // Métodos de Subject
    @Override
    public void agregar(Observer o) {
        observers.add(o);
    }


    @Override
    public void notificar(int x, int y) {
        for (Observer observer : observers) {
            observer.actualizar(x, y);
        }
    }


    // Métodos de movimiento
    public void mover(char direccion) {
        switch (direccion) {
            case 'a': // izquierda
                this.x.set(this.x.get() - 1);
                break;
            case 'd': // derecha
                this.x.set(this.x.get() + 1);
                break;
            case 'w': // arriba
                this.y.set(this.y.get() - 1);
                break;
            case 's': // abajo
                this.y.set(this.y.get() + 1);
                break;
            default:
                System.out.println("Dirección no válida");
        }
        notificar(this.x.get(), this.y.get());// Notifica a los observadores después de cada movimiento
    }

    // Getters para las coordenadas
    public int getX() {
        return x.get();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }

    public IntegerProperty yProperty() {
        return y;
    }
}
