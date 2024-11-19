package models;

public class Equipo {
    private String nombre;
    private int id;

    // contador de instancias
    private static int cont = 0;

    // Variables para mostrar los datos
    // en una tabla
    public static int longestNameSize = 0;

    public Equipo() {}


    public Equipo(String nombre) {
        this.setNombre(nombre);
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


    public static void printAllEquipos(Equipo[] equipos, String emptyDataMsg) {
        if (equipos != null && equipos[0] != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int numColWide = Integer.toString(cont).length() + 2;
            int idColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 10 + numColWide + idColWide + nameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "#", "ID", "NOMBRE");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s |%n");


            // Imprimimos el contenido
            int num = 1;
            for (Equipo equipo : equipos) {

                System.out.printf(formatContent, num,
                                                equipo.getId(), 
                                                equipo.getNombre());
                num++;
            }
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");


        } else {
            System.out.println(emptyDataMsg);
        }
    }
    
    public static void printEquipo(int indice, Equipo equipo) {
        if (equipo != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int numColWide = Integer.toString(cont).length() + 2;
            int idColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 10 + numColWide + idColWide + nameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "#", "ID", "NOMBRE");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ numColWide +"s "
                            .concat("| %-"+ idColWide +"s ")
                            .concat("| %-"+ nameColWide +"s |%n");


            // Imprimimos el contenido
            System.out.printf(formatContent, indice,
                                            equipo.getId(), 
                                            equipo.getNombre());
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
        }
    }
    
    public static void printListEquipos(Equipo[] equipos, String emptyDataMsg) {
        if (equipos != null && equipos[0] != null) {
            // Cabeceras
            // Calculamos los anchos de las columnas
            int numColWide = Integer.toString(cont).length() + 2;
            int nameColWide = (longestNameSize > "nombre".length() ? longestNameSize : "nombre".length()) + 2;

            // Creamos el formato de las cabeceras
            String formatHeader = "| %-"+ numColWide +"s "
                            .concat("| %-"+ nameColWide +"s |%n");

            // Calculamos el total del ancho de la tabla
            int totalLines = 7 + numColWide + nameColWide;

            // Imprimimos el borde superior de la tabla
            System.out.printf("-".repeat(totalLines) + "%n");
            
            // Imprimimos las cabeceras de las columnas
            System.out.printf(formatHeader, "#", "NOMBRE");

            // Imprimimos el borde que divide las cabeceras del contenido
            System.out.printf("-".repeat(totalLines) + "%n");
            

            // Contenido
            // Creamos el formato del contenido
            String formatContent = "| %-"+ numColWide +"s "
                            .concat("| %-"+ nameColWide +"s |%n");


            // Imprimimos el contenido
            int num = 1;
            for (Equipo equipo : equipos) {

                System.out.printf(formatContent, num, 
                                                equipo.getNombre());
                num++;
            }
            // Imprimimos el borde inferior para cerrar la tabla
            System.out.printf("-".repeat(totalLines) + "%n");


        } else {
            System.out.println(emptyDataMsg);
        }
    }
    

    public static boolean isEmpty() {
        // validamos si el contador de instancias está vacío
        return cont == 0;
    }

    public static Equipo[] eliminarEquipo(Equipo[] equiposArr, Equipo equipo) {
        Equipo[] equiposUpArr = new Equipo[equiposArr.length - 1];
        int index = 0;
        for (Equipo itemEquipo : equiposArr) {
            if (itemEquipo != equipo) {
                equiposUpArr[index] = itemEquipo;
                index++;
            }
            
        }
        return equiposUpArr;
    }
    
}
