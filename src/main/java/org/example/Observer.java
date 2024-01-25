package org.example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public interface Observer {
    void actualizar(int x, int y);
}