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
                    MenuUtility.header("Crear jugador");
                    // Pausar la ejecución del programa hasta que presione ENTER
                    ConsoleUtility.waitPressEnterKey(scanner);
                    break;
                case 2:
                    MenuUtility.header("Crear equipo");
                    // Pausar la ejecución del programa hasta que presione ENTER
                    ConsoleUtility.waitPressEnterKey(scanner);
                    break;
                case 3:
                    MenuUtility.header("Asignar jugador a equipo");
                    // Pausar la ejecución del programa hasta que presione ENTER
                    ConsoleUtility.waitPressEnterKey(scanner);
                    break;
                case 4:
                    MenuUtility.header("Mostrar lista de jugadores");

                    Jugador.printAllJugadores(jugadoresArr, "No hay jugadores registrados.");

                    // Pausar la ejecución del programa hasta que presione ENTER
                    ConsoleUtility.waitPressEnterKey(scanner);
                    break;
                case 5:
                    MenuUtility.header("Mostrar lista de equipos");

                    Equipo.printAllEquipos(equiposArr, "No hay equipos registrados.");

                    // Pausar la ejecución del programa hasta que presione ENTER
                    ConsoleUtility.waitPressEnterKey(scanner);
                    break;
                case 6:
                    showMenu = MenuUtility.exit();
                    break;
            }

            // Limpia la consola
            ConsoleUtility.cleanScreen();
            
        } while (showMenu);
    }
}
