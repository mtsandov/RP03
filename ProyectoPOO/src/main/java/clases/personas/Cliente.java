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
public class Cliente extends Persona{
    
    //Atributos
    private String datos;
    public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
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
    
    
    
}
