/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.personas;

import java.util.ArrayList;

/**
 *
 * @author Angello Bravo
 */
public class Empleado extends Persona {
    
    //Atributos
    private boolean estado;
    public static ArrayList <Empleado> listaEmpleados = new ArrayList<Empleado>(); //Lista Estatica de Empleados
    
    //Constructor
    public Empleado(boolean estado, String cedula, String nombre, String telef, String email) {
        super(cedula, nombre, telef, email);
        this.estado = estado;
    }
    
    //Getters
    public boolean isEstado() {
        return estado;
    }
    
    //Setters
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //Metodos
    
    @Override
    public String toString(){
        String info = "";
        if(isEstado()){
            info = super.toString();
        }
        return info;
    }
    
    
    
}
