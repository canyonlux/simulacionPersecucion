package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego extends Application {
    private static final int TAMAÑO_MAPA = 10;
    private Jugador jugador;
    private List<Enemigo> enemigos;

    private Scanner scanner;

    // Constructor, inicialización y otros métodos...



    // Método para verificar si algún enemigo ha capturado al jugador
    public Juego() {
        // Inicialización del jugador y enemigos...
        jugador = new Jugador(1, 1);
        enemigos = new ArrayList<>();
        // Añadir algunos enemigos...
        enemigos.add(new Enemigo(10, 10));
        // ...

        scanner = new Scanner(System.in);

        // Agregar los enemigos como observadores del jugador
        for (Enemigo enemigo : enemigos) {
            jugador.agregar(enemigo);
        }
    }

    // Método para mostrar el mapa
    public void mostrarMapa() {
        char[][] mapa = new char[TAMAÑO_MAPA][TAMAÑO_MAPA];

        // Inicializar el mapa con puntos
        for (int i = 0; i < TAMAÑO_MAPA; i++) {
            for (int j = 0; j < TAMAÑO_MAPA; j++) {
                mapa[i][j] = '.';
            }
        }

        // Colocar al jugador en el mapa
        mapa[jugador.getY() - 1][jugador.getX() - 1] = 'J';

        // Colocar a los enemigos en el mapa
        for (Enemigo enemigo : enemigos) {
            mapa[enemigo.getY() - 1][enemigo.getX() - 1] = 'E';
        }

        // Imprimir el mapa
        for (int i = 0; i < TAMAÑO_MAPA; i++) {
            for (int j = 0; j < TAMAÑO_MAPA; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean verificarCaptura() {
        for (Enemigo enemigo : enemigos) {
            if (enemigo.getX() == jugador.getX() && enemigo.getY() == jugador.getY()) {
                System.out.println("¡El jugador ha sido capturado por un enemigo!");
                return true; // Retorna true si algún enemigo captura al jugador
            }
        }
        return false; // Retorna false si el jugador no ha sido capturado
    }

    // Método para iniciar y ejecutar el juego
    public void jugar() {
        boolean jugadorCapturado = false;

        while (!jugadorCapturado) {
            mostrarMapa(); // Mostrar el mapa
            System.out.println("Mueve al jugador (w: arriba, s: abajo, a: izquierda, d: derecha): ");
            String movimiento = scanner.nextLine(); // Lee la entrada del usuario

            if (movimiento.length() > 0) {
                char direccion = movimiento.charAt(0);
                jugador.mover(direccion); // Mueve al jugador según la entrada

                // Actualizar la posición de los enemigos y verificar captura
                jugadorCapturado = verificarCaptura();
            }

            // Opcional: Mostrar las posiciones del jugador y enemigos
            System.out.println("Posición del Jugador: (" + jugador.getX() + ", " + jugador.getY() + ")");
            for (Enemigo enemigo : enemigos) {
                enemigo.mostrarPosicion();
            }
        }

        System.out.println("Fin del juego: el jugador ha sido capturado.");
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        Label[][] labels = new Label[TAMAÑO_MAPA][TAMAÑO_MAPA];

        for (int i = 0; i < TAMAÑO_MAPA; i++) {
            for (int j = 0; j < TAMAÑO_MAPA; j++) {
                labels[i][j] = new Label(".");
                gridPane.add(labels[i][j], j, i);
            }
        }

        labels[jugador.getY() - 1][jugador.getX() - 1].setText("J");

        for (Enemigo enemigo : enemigos) {
            labels[enemigo.getY() - 1][enemigo.getX() - 1].setText("E");
        }

        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

