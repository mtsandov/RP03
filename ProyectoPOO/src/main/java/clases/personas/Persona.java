/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.personas;

/**
 *
 * @author Angello Bravo
 */
public abstract class Persona {
    //Atributos
    private String cedula;
    private String nombre;
    private String telef;
    private String email;
    
    //Constructor
    public Persona(String cedula, String nombre, String telef, String email){
        this.cedula = cedula;
        this.nombre = nombre;
        this.telef = telef;
        this.email = email;
    }
    
    //getters
    public String getCedula(){
        return cedula;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTelef(){
        return telef;
    }
    public String getEmail(){
        return email;
    }
    
    //Setters

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
