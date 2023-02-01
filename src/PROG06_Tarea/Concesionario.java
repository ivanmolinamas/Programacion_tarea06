package PROG06_Tarea;

/**
 *
 * @author IVAN
 * 
 * Esta clase Concesionario tiene los metodos para poder interactuar con la principal
 * y modificar y crear objetos en el array Concesionario.
 */
public class Concesionario {
    // atributos del array
    private Vehiculo[] Vehiculos;
    private int numVehiculos;
 
    // 

    /**
     * Array de 50 Vehiculos (objeto Vehiculo), este empieza en 0
     */
    public Concesionario() {
        this.numVehiculos = 0;
        this.Vehiculos = new Vehiculo[50];
    }
    
    /**
     * Metodo para buscar vehiculos
     * @param matricula Del vehiculo que se quiere buscar
     * @return Devuelve un toString con los datos del vehiculo en caso de existir,
     * en caso contrairo devuelve un null.
     */
    public String buscaVehiculo(String matricula) {
        /**
         * este metodo busca el vehiculo dando una matricula por argumento
         * si existe ese vehiculo con matricula, devuelve un toString
         * en caso contrario devuelve null
         */

        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = this.Vehiculos[i];
            if (v.getMatricula().equals(matricula)) {
                return v.toString();
            }
        }
        return null;
    }
 
    /**
     * metodo para insertar vehiculos
     * @param v es el objeto vehiculo cual se va a añadir al array
     * @return si el array esta completo devuelve -1
     * si el vehiculo ya existe, porque lo comprueba, devuelve -2
     * si lo introduce, devuelve 0, ademas suma al int numVehiculos
     */
    public int insertarVehiculo(Vehiculo v) {
   
        if (this.numVehiculos == this.Vehiculos.length) {
            return -1; // concesionario completo
        }
        if (this.buscaVehiculo(v.getMatricula()) != null) {
            return -2;//vehiculo ya existe
        } else {
            this.Vehiculos[this.numVehiculos] = v;
            this.numVehiculos++;
            return 0;// creado
        }
    }
 
    /**Metodo para listar vehiculos
     * Devuelve un toString de todos los objetos del array que existan.
     * 
     */
    public void listarVehiculos() {
        // con un bucle for hacmeos que vaya pasando por todo el array
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = this.Vehiculos[i];
            System.out.println(v.toString());
        }
    }
     
    /**
     * metodo para actualizar los kilometros
     * @param matricula matricula cual se quiere buscar
     * @param kms Kilometros nuevos que se quieren añadir
     * @return true si lo ha realizado con extito, False si no lo ha realizado.
     */
    public boolean actualizaKms(String matricula, int kms){
        // con el bucle for se inicia una sencuencia de numeros hasta el numero de 
        //vehiculos que existen, ese numoero se añade como variable al objeto vehiculo
        // si coincide el vehiculo, su numero y la matricula con la matricula que pasamos
        //entonces seteamos los nuevos kilometros. en caso contrario, retormamos falso.
        for(int i = 0; i < numVehiculos;i++){
            Vehiculo v = this.Vehiculos[i];
            
            if(v.getMatricula().equals(matricula)){
                v.setNum_kms(kms);
                return true;    
            }
        }
        return false;
    }
}
