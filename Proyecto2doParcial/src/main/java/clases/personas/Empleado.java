/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.personas;

import clases.Servicio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        
        try(BufferedReader bf = new BufferedReader(new FileReader(ruta))){
            String line;
            while((line = bf.readLine()) != null){
                String[] datos = line.split(";");
                Empleado em = new Empleado(Boolean.parseBoolean(datos[0]), datos[1], datos[2], datos[3],datos[4]);
                lista.add(em);
            }
            
        }
        catch(IOException e){
            System.out.println("Archivo No Encontrado");
        }
        catch(Exception ex){
            System.out.println("Error al Procesar el Archivo");
        }
        return lista;
    }
    
    
    
}
