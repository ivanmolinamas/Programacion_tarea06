package Prog06_Tarea;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author IVAN Clase principal
 */
public class Principal {

    static Scanner teclado = new Scanner(System.in);

    public static int mostrarMenu() {
        System.out.println("GESTION DE VEHICULOS DEL CONCESIONARIO");

        System.out.println("1 - Nuevo vehiculo");
        System.out.println("2 - Listar vehiculos");
        System.out.println("3 - Buscar vehiculo");
        System.out.println("4 - Modificar kilometros de vehiculo");
        System.out.println("5 - Salir");

        int opcion = teclado.nextInt();
        teclado.nextLine();
        return opcion;
    }

    public static void main(String[] args) {
        int opcion;

        String marca, matricula, descripcion, propietario, dni;
        int kilometros, precio, nuevosKilometros;
        LocalDate matri_fecha;
        int matri_dia, matri_mes, matri_anyo;

        boolean check = true;
        
        // MAXIMO 50 COCHES
        // CREAR ARRAY Y CREAR CLASE VEHICULO
        
        //vehiculo coche1 = null;
        
        System.out.println("BIENVENIDO");
        
        
        do{
          opcion = mostrarMenu();  
          
          switch(opcion){
              case 1:
                  // aqui va la creacion de un nuevo vehiculo, se pediran los datos
                  // se añadiran a variables y luego con esas variables se creara
                  //el objeto con argumentos.
                  //hay que buscar la forma de que se haga un objeto nuevo cada vez
                  // maximo 50 coches
                  System.out.println("Nuevo Vehiculo");
              break;
              case 2:
                  System.out.println("Listar Vehiculos");
              break;
              case 3:
                  System.out.println("Buscar Vehiculo");
              break;
              case 4:
                  System.out.println("Modificar kilometros");
              break;
              case 5:
                  System.out.println("Fin del programa. Adios!");
              break;
              default:
                  System.out.println("Opcion incorrecta.");
              
          }
        }while(opcion != 5);
        
        
    }

}
