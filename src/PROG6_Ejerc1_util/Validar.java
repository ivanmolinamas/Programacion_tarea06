package PROG6_Ejerc1_util;

import java.time.LocalDate;

/**
 *
 * @author ivanm
 */
public class Validar {

    public static boolean validarMatricula(String matricula) {
        // este metodo valida si el formato es NNNNLLL
        // cuatro numeros y 3 letras mayusculas
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }

    public static boolean validarDNI(String DNI) {
        return DNI.matches("^[0-9]{7,8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K]$");
    }

    public static boolean validarNombre(String nombre) {
        if (nombre.length() > 40) {
            return false;
        }

        char caracter;
        int numEspacios = 0;
        for (int i = 0; i < nombre.length(); i++) {
            caracter = nombre.charAt(i);
            if (caracter == ' ') {
                numEspacios++;
            }
            if (Character.isDigit(caracter)) {
                return false;
            }
        }
        if(numEspacios >= 2) {
            return true;
        }
        return false;
    }
    
     public static boolean validaFecha(LocalDate matri_fecha)
	{
        return matri_fecha.isBefore(LocalDate.now());
    }

}
