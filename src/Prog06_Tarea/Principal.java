package Prog06_Tarea;

import PROG5_Ejerc1_util.Validar;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author IVAN Clase principal
 */
public class Principal {

    static Scanner teclado = new Scanner(System.in);

    public static int mostrarMenu() {
        // metodo para imprimir la opcion de menu por pantalla
        // este metodo tambien recoge la opcion
        System.out.println("GESTION DE VEHICULOS DEL CONCESIONARIO");

        System.out.println("1 - Nuevo vehiculo");
        System.out.println("2 - Listar vehiculos");
        System.out.println("3 - Buscar vehiculo");
        System.out.println("4 - Modificar kilometros de vehiculo");
        System.out.println("5 - Salir");
        System.out.println("Elige una opcion:");
        // comprobar

        int opcion = teclado.nextInt();
        teclado.nextLine();
        return opcion;
    }

    public static void main(String[] args) {
        int opcion;

        //variables que se usaran para recoger información del vehiculo.
        String marca, matricula, busca_matricula, descripcion, propietario, dni;
        int kilometros, precio, nuevosKilometros;
        int dia_matri,mes_matri,anyo_matri;
        LocalDate matri_fecha;
        int matri_dia, matri_mes, matri_anyo;

        
        Concesionario concesionario = new Concesionario();
        
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
                  
                  // inicio de pedir datos al usuario para crear un vehiculo nuevo
                  // los datos se guadaran en las variables, estas si son correctas 
                  // se pasaran todas a la vez al constructor.
                  
                  System.out.println("Introduce la marca del vehiculo");
                  matricula = teclado.nextLine();

                  // con do while creamos bucle hasta que la matricula sea correcta
                  do{
                      System.out.println("Introduce la matricula del vehciulo en formato NNNNLLL");
                      matricula = teclado.nextLine(); 
                      // con el if lanzamos el mensaje de matricula incorrecta
                      if(!Validar.validarMatricula(matricula)){
                          System.out.println("Matricula inocrrecta");
                      }
                  }while(!Validar.validarMatricula(matricula));
                  
                  do{
                      System.out.println("Introduzca los kilometros");
                      kilometros = teclado.nextInt();
                      teclado.nextLine(); 
                      if(0>kilometros){
                          System.out.println("Kilometros incorrectos");
                      }
                  }while(0 > kilometros);
                 
                 
                  System.out.println("Introduce precio del vehiculo");
                  precio = teclado.nextInt();
                  teclado.nextLine();
                  
                  do {
                      System.out.println("Introduce el nombre del propietario");
                      propietario = teclado.nextLine();
                      if(!Validar.validarNombre(propietario)){
                          System.out.println("Nombre incorrecto, introduzca nombre y apellidos");
                      }
                  } while (!Validar.validarNombre(propietario));

                  // Validación del DNI, con un do while se pedira hasta que sea correcto
                  do{
                    System.out.println("Introduce el DNI del propietario");
                  dni = teclado.nextLine(); 
                  if(!Validar.validarDNI(dni)){
                      System.out.println("DNI incorrecto.");
                  }
                  }while(!Validar.validarDNI(dni));
  
                  do{
                      System.out.println("Introduce el dia de matriculacion");
                      dia_matri = teclado.nextInt();
                      teclado.nextLine();

                      System.out.println("Introduce el mes de matriculacion");
                      mes_matri = teclado.nextInt();
                      teclado.nextLine();;

                      System.out.println("Introduce el año de matricuiacon");
                      anyo_matri = teclado.nextInt();
                      teclado.nextLine();
                   
                       matri_fecha = LocalDate.of(anyo_matri, mes_matri, dia_matri);
                       if(!Validar.validaFecha(matri_fecha)){
                           System.out.println("Fecha incorrecta, superior a la actual");
                       }
                   }while(!Validar.validaFecha(matri_fecha));       
                  
            
                          
              break;
              case 2:
                  System.out.println("Listar Vehiculos");
                  concesionario.listarVehiculos();
                  
              break;
              case 3:
                  System.out.println("Buscar Vehiculo");
                  System.out.println("Inserta matricula a buscar");
                  busca_matricula = teclado.next();
                  
                  
                  
                  String v = concesionario.buscaVehiculo(busca_matricula);
                  
                  if( v != null){
                      System.out.println(v);
                  }else{
                      System.out.println("No existe vehiculo con la matricula introducida");
                  }
              break;
              case 4:
                  System.out.println("Modificar kilometros");
                  
                  System.out.println("Inserta la matricula del coche");
                  busca_matricula = teclado.nextLine();
                  System.out.println("Inserta el nuevo numero de kilometros");
                  nuevosKilometros = teclado.nextInt();
                 
                   if(concesionario.actualizaKms(busca_matricula, nuevosKilometros)){
                       System.out.println("Se han actualizado los kilometros correctamente");
                  }else{
                      System.out.println("No existe vehículo con la matrícula introducida");
                  }
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
