/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.personas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angello Bravo
 */
public class Cliente extends Persona{
    //Variables
    Scanner sc = new Scanner(System.in);
    
    //Atributos
    private String datos;
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    //Constructor
    public Cliente(String datos, String cedula, String nombre, String telef, String email) {
        super(cedula, nombre, telef, email);
        this.datos = datos;
    }
    
    //getters
    public String getDatos() {
        return datos;
    }
    
    //Setters
    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    
    //Metodos
    //Metodo toString que presentara la informacion de los clientes.
    @Override
    public String toString(){
        return super.toString() + " - " + getDatos();
    }
    
    //Metodo que cargara los datos de los archivos.
    public static ArrayList<Cliente> cargarClientes(String ruta){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(ruta))){
            String line;
            while((line = bf.readLine()) != null){
                String[] datos = line.split(";");
                Cliente c = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
                listaClientes.add(c);
            }
        }
        catch(IOException e){
            System.out.println("Archivo No Encontrado");
        }
        catch(Exception ex){
            System.out.println("Error al procesar el archivo");
        }
        
        return listaClientes;
        
    }
    
    
    
}
