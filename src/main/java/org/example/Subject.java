package org.example;

public interface Subject {
    void agregar(Observer o);
    void eliminar(Observer o);
    void notificar();
}
