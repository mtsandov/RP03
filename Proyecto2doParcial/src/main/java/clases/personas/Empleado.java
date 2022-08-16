/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.personas;

import clases.Servicio;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    
    //Cargar arraylist de empleados
    public static ArrayList<Empleado> cargarEmpleados(String ruta){
        ArrayList<Empleado> lista = new ArrayList<>();
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(ruta))){
            lista = (ArrayList<Empleado>)input.readObject();
        }
        catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println("Clase no encontrada");
        }
        
        return lista;
    }
    
    
    
}
