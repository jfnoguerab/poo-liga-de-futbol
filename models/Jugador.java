package models;

public class Jugador {
    private String nombre;
    private Equipo equipo;
    private int id;

    // contador de instancias
    private static int cont = 0;

    // Variables para mostrar los datos
    // en una tabla
    public static int longestNameSize = 0;
    public static int longestTeamNameSize = 0;


    public Jugador(){}

    public Jugador(String nombre, Equipo equipo) {
        this.setNombre(nombre);
        this.setEquipo(equipo);
        cont++;
        this.id = cont;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        if (this.nombre.length() > longestNameSize) {
            longestNameSize = this.nombre.length();
        }
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
        if (this.equipo != null) {
            if (this.equipo.getNombre().length() > longestTeamNameSize) {
                longestTeamNameSize = this.equipo.getNombre().length();
            }
        }
    }
    

    public static void printAllJugadores(Jugador[] jugadores, String emptyDataMsg) {
        if (jugadores != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int idColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;
            int teamNameColWide = (longestTeamNameSize > "Sin equipo".length() ? longestTeamNameSize : "Sin equipo".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ idColWide +"s "
                            .concat("| %-"+ nameColWide +"s ")
                            .concat("| %-"+ teamNameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 10 + idColWide + nameColWide + teamNameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "ID", "NOMBRE", "EQUIPO");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ idColWide +"s "
                            .concat("| %-"+ nameColWide +"s ")
                            .concat("| %-"+ teamNameColWide +"s |%n");


            // Imprimimos el contenido
            for (Jugador jugador : jugadores) {

                System.out.printf(formatContent, jugador.getId(), 
                                                jugador.getNombre(),
                                                jugador.equipo != null ? jugador.equipo.getNombre() : "Sin equipo");
            }
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");


        } else {
            System.out.println(emptyDataMsg);
        }
    }
}
