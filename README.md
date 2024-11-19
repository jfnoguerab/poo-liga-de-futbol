## POO (Nivel avanzado): Asociación de objetos

### Actividad: Liga de fútbol I

El objetivo de esta actividad es crear un proyecto para  gestionar los jugadores de una liga de fútbol. Deberás manejar equipos y jugadores con una relación de agregación, permitiendo al usuario interactuar con ellos a través de un menú en consola.

Para esto deberás generar una clase `Jugador` y una `Equipo`. Para relacionar ambas clases vamos a utilizar una agregación, recomendamos que el jugador tenga un atributo del tipo `Equipo` para facilitar la resolución. Con esto, el menú deberá permitir realizar las siguientes acciones:

1. **Crear jugador:** Esta opción te permitirá crear un nuevo jugador. Deberás pedir al usuario el nombre del jugador y mostrar la lista de equipos disponibles para que elija uno, si no hay equipos creados entonces debería mostrar un mensaje que diga que no hay equipos disponibles y setear null.

2. **Crear equipo:** Esta opción te permitirá crear un nuevo equipo. Deberás pedir al usuario el nombre del equipo.

3. **Asignar jugador a equipo:** Con esta opción, podrás asignar un jugador existente a un equipo existente. Deberás permitir al usuario seleccionar de la lista de jugadores y equipos existentes.

4. **Mostrar lista de jugadores:** Esta opción mostrará una lista de todos los jugadores creados, junto con el nombre del equipo al que están asignados, si corresponde.

5. **Mostrar lista de equipos:** Esta opción mostrará una lista de todos los equipos creados.

6. **Salir:** Esta opción termina la ejecución del programa.

---

© 2024 | Desarrollado por [Fernando Noguera](https://www.linkedin.com/in/jfnoguerab/)