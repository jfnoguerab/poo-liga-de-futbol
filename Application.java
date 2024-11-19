import java.util.Arrays;
import java.util.Scanner;

import models.Equipo;
import models.Jugador;
import utils.ConsoleUtility;
import utils.MenuUtility;

public class Application {

    private static Scanner scanner = new Scanner(System.in);
    private static Jugador[] jugadoresArr = new Jugador[3];
    private static Equipo[] equiposArr = new Equipo[3];

    public static void main(String[] args) {
        try {

            // Definimos unos valores por defecto
            Equipo eq1 = new Equipo("warriors");
            Equipo eq2 = new Equipo("Celtics");
            Equipo eq3 = new Equipo("Bulls");

            Jugador jug1 = new Jugador("John Smith");
            jug1.setEquipo(eq1);
            
            Jugador jug2 = new Jugador("Sara Smith");
            jug2.setEquipo(eq2);
            
            Jugador jug3 = new Jugador("Juan Perez");
            jug3.setEquipo(eq3);

            // Asignamos los valores
            equiposArr[0] = eq1;
            equiposArr[1] = eq2;
            equiposArr[2] = eq3;

            jugadoresArr[0] = jug1;
            jugadoresArr[1] = jug2;
            jugadoresArr[2] = jug3;



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
                "Eliminar jugador",
                "Eliminar equipo",
                "Seleccionar jugador",
                "Seleccionar equipo",
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
                    eliminarJugador();
                    break;
                case 7:
                    eliminarEquipo();
                    break;
                case 8:
                    seleccionarJugador();
                    break;
                case 9:
                    seleccionarEquipo();
                    break;
                case 10:
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
    
    
    private static void eliminarJugador() {
        MenuUtility.header("Eliminar jugador");

        if (Jugador.isEmpty()) {
            System.out.println("\n No hay jugadores registrados.");
        } else {
            System.out.println("\nLista de jugadores:");

            Jugador.printAllJugadores(jugadoresArr, "");

            // Solicitamos la selección del jugador a asignar
            int indiceJugador = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del jugador correspondiente: ", 1, jugadoresArr.length);

            Jugador delJugador = jugadoresArr[indiceJugador - 1];

            // Mostramos un mensaje para validar si desea eliminar al jugador
            Character[] opClearFilters = {'S', 'N'};
            Character clearFilters = MenuUtility.solicitaCharacter(scanner, "\nSeguro que desea eliminar a \""+delJugador.getNombre()+"\" [S/N]?", opClearFilters);
    
            if (clearFilters == 'S') {
                jugadoresArr = Jugador.eliminarJugador(jugadoresArr, delJugador);

                System.out.println("\nEl jugador se eliminó exitosamente.");
            }
        }


        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
    
    private static void eliminarEquipo() {
        MenuUtility.header("Eliminar equipo");

        if (Equipo.isEmpty()) {
            System.out.println("\n No hay equipos registrados.");
        } else {
            System.out.println("\nLista de equipos:");

            Equipo.printAllEquipos(equiposArr, "");

            // Solicitamos la selección del equipo a asignar
            int indiceEquipo = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del equipo correspondiente: ", 1, equiposArr.length);

            Equipo delEquipo = equiposArr[indiceEquipo - 1];

            // Mostramos un mensaje para validar si desea eliminar al equipo
            Character[] opClearFilters = {'S', 'N'};
            Character clearFilters = MenuUtility.solicitaCharacter(scanner, "\nSeguro que desea eliminar al equipo \""+delEquipo.getNombre()+"\" [S/N]?", opClearFilters);
    
            if (clearFilters == 'S') {
                equiposArr = Equipo.eliminarEquipo(equiposArr, delEquipo);

                // Eliminamos las relaciones del equipo con lo jugadores
                Jugador.clearRelationshipWithEquipo(jugadoresArr, delEquipo);

                System.out.println("\nEl equipo se eliminó exitosamente.");
            }
        }


        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
    
    private static void seleccionarJugador() throws Exception {
        MenuUtility.header("Seleccionar jugador");

        if (Jugador.isEmpty()) {
            System.out.println("No hay jugadores registrados.");

            // Pausar la ejecución del programa hasta que presione ENTER
            ConsoleUtility.waitPressEnterKey(scanner);

            return;
        }

        System.out.println("\nLista de jugadores:");

        Jugador.printListJugadores(jugadoresArr, "");

        // Solicitamos la selección del jugador a asignar
        int indiceJugador = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del jugador que desea seleccionar: ", 1, jugadoresArr.length);

        subMenuJugador(indiceJugador, jugadoresArr[indiceJugador - 1]);

    }

    private static void subMenuJugador(int indice, Jugador jugador) throws Exception {
        boolean showMenu = true;
        int opMenuUsu = 0;
        // Menú
        String[] menu = {
            "Ver detalles",
            "Cambiar nombre",
            "Cambiar equipo",
            "Volver al menú principal"
        };

        do {            
            // Limpia la consola
            ConsoleUtility.cleanScreen();
    
            MenuUtility.header("Jugador " + jugador.getNombre());
            
            System.out.println("Menú: ");
    
            // Muestra el menú y devuelve la opción válida ingresada por el usuario que este dentro del rango del menú
            opMenuUsu = MenuUtility.createMenuAndGetOption(scanner, menu, "\nIngrese el número de la opción correspondiente: ");
    
            // Limpia la consola
            ConsoleUtility.cleanScreen();
    
            switch (opMenuUsu) {
                case 1:
                    verDetalles(indice, jugador);
                    break;
                case 2:
                    cambiarNombre(indice, jugador);
                    break;
                case 3:
                    cambiarEquipo(indice, jugador);
                    break;
                case 4:
                    showMenu = MenuUtility.exit("\nVolviendo al menú principal...\n", 1500);
                    break;
            }
        } while (showMenu);
    }

    private static void verDetalles(int indice, Jugador jugador) {
        MenuUtility.header("Ver detalles");

        Jugador.printJugador(indice, jugador);

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
    
    private static void verDetalles(int indice, Equipo equipo) {
        MenuUtility.header("Ver detalles");

        Equipo.printEquipo(indice, equipo);

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
    
    private static void cambiarNombre(int indice, Jugador jugador) {
        MenuUtility.header("Cambiar nombre del jugador "+ jugador.getNombre());

        // Solicitamos los datos
        String nombreJugador = MenuUtility.solicitarCadena(scanner, "Ingrese el nombre del jugador: ");

        jugador.setNombre(nombreJugador);

        jugadoresArr[indice - 1] = jugador;

        System.out.println("\nEl jugador se actualizó existosamente.");

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
    
    private static void cambiarNombre(int indice, Equipo equipo) {
        MenuUtility.header("Cambiar nombre del equipo "+ equipo.getNombre());

        // Solicitamos los datos
        String nombreEquipo = MenuUtility.solicitarCadena(scanner, "Ingrese el nombre del equipo: ");

        equipo.setNombre(nombreEquipo);

        equiposArr[indice - 1] = equipo;

        // Actualizamos el nuevo nombre del equipo en los jugadores

        Jugador.updateRelationshipWithEquipo(jugadoresArr, equipo.getId(), equipo);

        System.out.println("\nEl equipo se actualizó existosamente.");

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }

    private static void cambiarEquipo(int indice, Jugador jugador) {
        MenuUtility.header("Cambiar equipo del jugador "+ jugador.getNombre());

        System.out.println("\nLista de equipos:");

        Equipo.printAllEquipos(equiposArr, "");

        // Solicitamos la selección del equipo a asignar
        int indiceEquipo = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del equipo correspondiente (0 para ninguno): ", 0, equiposArr.length);

        // Asignamos el equipo seleccionado al jugador seleccionado
        if (indiceEquipo == 0) {
            jugador.setEquipo(null);
        } else {
            jugador.setEquipo(equiposArr[indiceEquipo - 1]);
        }

        System.out.println("\nEl jugador se actualizó existosamente.");


        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
    
    private static void seleccionarEquipo() throws Exception{
        MenuUtility.header("Seleccionar equipo");

        if (Equipo.isEmpty()) {
            System.out.println("No hay equipos registrados.");

            // Pausar la ejecución del programa hasta que presione ENTER
            ConsoleUtility.waitPressEnterKey(scanner);

            return;
        }

        System.out.println("\nLista de equpos:");

        Equipo.printListEquipos(equiposArr, "");

        // Solicitamos la selección del equipo a asignar
        int indiceEquipo = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del equipo que desea seleccionar: ", 1, equiposArr.length);

        subMenuEquipo(indiceEquipo, equiposArr[indiceEquipo - 1]);
    }

    private static void subMenuEquipo(int indice, Equipo equipo) throws Exception {
        boolean showMenu = true;
        int opMenuUsu = 0;
        // Menú
        String[] menu = {
            "Ver detalles",
            "Cambiar nombre",
            "Agregar jugador al equipo",
            "Mostrar jugadores del equipo",
            "Volver al menú principal"
        };

        do {            
            // Limpia la consola
            ConsoleUtility.cleanScreen();
    
            MenuUtility.header("Equipo " + equipo.getNombre());
            
            System.out.println("Menú: ");
    
            // Muestra el menú y devuelve la opción válida ingresada por el usuario que este dentro del rango del menú
            opMenuUsu = MenuUtility.createMenuAndGetOption(scanner, menu, "\nIngrese el número de la opción correspondiente: ");
    
            // Limpia la consola
            ConsoleUtility.cleanScreen();
    
            switch (opMenuUsu) {
                case 1:
                    verDetalles(indice, equipo);
                    break;
                case 2:
                    cambiarNombre(indice, equipo);
                    break;
                case 3:
                    agregarJugador(equipo);
                    break;
                case 4:
                    mostrarJugadoresDelEquipo(equipo);
                    break;
                case 5:
                    showMenu = MenuUtility.exit("\nVolviendo al menú principal...\n", 1500);
                    break;
            }
        } while (showMenu);
    }

    private static void agregarJugador(Equipo equipo) {
        MenuUtility.header("Agregar jugador al equipo "+ equipo.getNombre());

        System.out.println("\nLista de jugadores:");

        Jugador.printListJugadores(jugadoresArr, "");;

        // Solicitamos la selección del jugador a asignar
        int indiceJugador = MenuUtility.solicitaNumeroMenu(scanner, "\nIngrese el número del jugador correspondiente: ", 1, jugadoresArr.length);

        jugadoresArr[indiceJugador - 1].setEquipo(equipo);

        System.out.println("\nEl jugador se agregó existosamente.");

        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }

    private static void mostrarJugadoresDelEquipo(Equipo equipo) {
        MenuUtility.header("Mostrar jugadores del equipo "+ equipo.getNombre());

        int totalJugadores = Jugador.contarJugadoresByEquipo(jugadoresArr, equipo);
        if (totalJugadores == 0) {
            System.out.println("\n El equipo no posee jugadores");
        } else {
            Jugador.printListJugadores(jugadoresArr, equipo, "");
        }


        // Pausar la ejecución del programa hasta que presione ENTER
        ConsoleUtility.waitPressEnterKey(scanner);
    }
}
