
package org.example;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface Subject {
    ListProperty<Observer> observers = new SimpleListProperty<>(FXCollections.observableArrayList());

    default void agregar(Observer o) {
        observers.add(o);
    }

    default void notificar(int x, int y) {
        observers.forEach(observer -> observer.actualizar(x, y));
    }
}
