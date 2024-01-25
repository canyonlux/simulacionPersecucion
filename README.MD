Simulación de Persecución
Descripción
Este proyecto es una aplicación de consola en Java que simula un juego de persecución. En el juego, un jugador se mueve en un mapa intentando evadir a varios enemigos. Los enemigos reaccionan a los movimientos del jugador y se mueven en consecuencia para perseguirlo. El juego termina cuando un enemigo alcanza la posición del jugador.

Características
Mapa de 30x30 para la simulación.
El jugador y los enemigos se mueven dentro del mapa.
Los enemigos siguen al jugador basándose en sus movimientos.
La partida termina cuando un enemigo captura al jugador.
Requisitos
Java 8 o superior.
JavaFX (para la gestión de listas observables).
Estructura del Proyecto
El proyecto consta de las siguientes clases principales:

Juego: Controla la lógica principal del juego.
Jugador: Representa al jugador, maneja su posición y movimientos.
Enemigo: Representa a los enemigos, se actualiza en respuesta a los movimientos del jugador.
Cómo Jugar
Ejecute la clase Juego para iniciar la simulación.
Utilice las teclas w, a, s, d para mover al jugador hacia arriba, izquierda, abajo y derecha, respectivamente.
El juego muestra el mapa después de cada movimiento, donde 'J' representa al jugador y 'E' a los enemigos.
El juego termina cuando un enemigo alcanza la misma posición que el jugador.
Configuración y Personalización
Puede modificar el tamaño del mapa cambiando la constante TAMANIO_MAPA en las clases Juego y Jugador.
La dificultad puede ajustarse cambiando la lógica de movimiento de los enemigos en la clase Enemigo.
Desarrollo y Contribuciones
Este proyecto es un ejemplo básico y está abierto a mejoras y contribuciones. Si desea contribuir, por favor considere lo siguiente:




Contacto
Creado por Canyonlux