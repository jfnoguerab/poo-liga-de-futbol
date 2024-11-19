import java.util.Arrays;
import java.util.Scanner;

import models.Equipo;
import models.Jugador;
import utils.ConsoleUtility;
import utils.MenuUtility;

public class Application {

    private static Scanner scanner = new Scanner(System.in);
    private static Jugador[] jugadoresArr = new Jugador[1];
    private static Equipo[] equiposArr = new Equipo[1];

    public static void main(String[] args) {
        try {
            mainMenu();
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void mainMenu() throws Exception {
        boolean showMenu = true;
        int opMenuUsu = 0;

        do {
            // Limpia la consola
            ConsoleUtility.cleanScreen();

            MenuUtility.header("Liga de fútbol");

            // Menu
            String[] menu = {
                "Crear jugador",
                "Crear equipo",
                "Asignar jugador a equipo",
                "Mostrar lista de jugadores",
                "Mostrar lista de equipos",
                "Salir"
            };

            // Muestra el menú y devuelve la opción válida ingresada por el usuario que este dentro del rango del menú
            opMenuUsu = MenuUtility.createMenuAndGetOption(scanner, menu, "\nIngrese el número de la opción correspondiente: ");

            // Limpia la consola
            ConsoleUtility.cleanScreen();

            // Opciones del menú
            switch (opMenuUsu) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    crearEquipo();
                    break;
                case 3:
                    asignarJugadorAEquipo();
                    break;
                case 4:
                    mostrarJugadores();
                    break;
                case 5:
                    mostrarEquipos();
                    break;
                case 6:
                    showMenu = MenuUtility.exit();
                    break;
            }

            // Limpia la consola
            ConsoleUtility.cleanScreen();
            
        } while (showMenu);
    }

    private static void crearJugador() {
        MenuUtility.header("Crear jugador");

        // Solicitamos los datos
        String nombreJugador = MenuUtility.solicitarCadena(scanner, "Ingrese el nombre del jugador: ");

        // Si ya hay registrado algún jugador debemos aumentar en 1 el tamaño del arreglo
        if (jugadoresArr[jugadoresArr.length - 1] != null) {
            jugadoresArr = Arrays.copyOf(jugadoresArr, jugadoresArr.length + 1);
        }

        // Creamos la instancia del jugador
        Jugador nuevoJugador = new Jugador(nombreJugador);

        if (Equipo.isEmpty()) {
            System.out.println("\nNo hay equipos disponibles. El jugador se creará sin equipo.");
        } else {
            System.out.println("\nEquipos disponibles:");
            Equipo.printAllEquipos(equiposArr, "");
            // Solicitamos la selección del equipo a asignar
            int indiceEquipo = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del equipo correspondiente (0 para ninguno): ", 0, equiposArr.length);

            if (indiceEquipo >= 1 && indiceEquipo <= equiposArr.length) {
                nuevoJugador.setEquipo(equiposArr[indiceEquipo - 1]);
            }
        }

        // Asignamos los valores
        jugadoresArr[jugadoresArr.length - 1] = nuevoJugador;

        System.out.println("\nJugador creado exitosamente.");

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }

    private static void crearEquipo() {
        MenuUtility.header("Crear equipo");

        // Solicitamos los datos
        String nombreEquipo = MenuUtility.solicitarCadena(scanner, "Ingrese el nombre del equipo: ");

        // Si ya hay registrado algún equipo debemos aumentar en 1 el tamaño del arreglo
        if (equiposArr[equiposArr.length - 1] != null) {
            equiposArr = Arrays.copyOf(equiposArr, equiposArr.length + 1);
        }

        // Creamos la instancia del equipo
        Equipo nuevoEquipo = new Equipo(nombreEquipo);

        // Asignamos los valores
        equiposArr[equiposArr.length - 1] = nuevoEquipo;

        System.out.println("\nEquipo creado exitosamente.");

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }

    private static void asignarJugadorAEquipo() {
        MenuUtility.header("Asignar jugador a equipo");

        if (Jugador.isEmpty() || Equipo.isEmpty()) {
            System.out.println("No hay jugadores o equipos registrados.");

            // Pausar la ejecución del programa hasta que presione ENTER
            ConsoleUtility.waitPressEnterKey(scanner);

            return;
        }

        System.out.println("\nLista de jugadores:");

        Jugador.printAllJugadores(jugadoresArr, "");

        // Solicitamos la selección del jugador a asignar
        int indiceJugador = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del jugador correspondiente: ", 1, jugadoresArr.length);
        
        
        System.out.println("\nLista de equipos:");

        Equipo.printAllEquipos(equiposArr, "");

        // Solicitamos la selección del equipo a asignar
        int indiceEquipo = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del equipo correspondiente: ", 1, equiposArr.length);

        // Asignamos el equipo seleccionado al jugador seleccionado
        jugadoresArr[indiceJugador - 1].setEquipo(equiposArr[indiceEquipo - 1]);

        System.out.println("\nEl equipo seleccionado se asignó exitosamente al jugador.");



        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }

    private static void mostrarJugadores() {
        MenuUtility.header("Mostrar lista de jugadores");

        Jugador.printAllJugadores(jugadoresArr, "No hay jugadores registrados.");

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }

    private static void mostrarEquipos() {
        MenuUtility.header("Mostrar lista de equipos");

        Equipo.printAllEquipos(equiposArr, "No hay equipos registrados.");

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
}
