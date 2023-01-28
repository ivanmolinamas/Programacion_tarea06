/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prog06_Tarea;

/**
 *
 * @author IVAN
 */
public class Concesionario {
    
// array
    private Vehiculo[] Vehiculos;
    private int numVehiculos;
    
// constructor
    public Concesionario() {
        this.numVehiculos = 0;
        this.Vehiculos = new Vehiculo[50];
    }
// metodo para buscar vehiculos
    public String buscaVehiculo(String matricula) {

        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = this.Vehiculos[i];
            if (v.getMatricula().equals(matricula)) {
                return v.toString();
            }
        }
        return null;
    }
// metodo para insertar vehiculos
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
// metodo para listar vehiculos
    public void listarVehiculos() {
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = this.Vehiculos[i];
            System.out.println(v.toString());
        }
    }
    
    // metodo para actualizar los kilometros
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
