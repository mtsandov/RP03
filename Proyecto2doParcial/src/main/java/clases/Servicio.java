/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Angello Bravo
 */
public class Servicio implements Serializable{
    //Atributos
    private String tipo;
    private float duracion;
    private float precio;
    private boolean estado;
    public static ArrayList<Servicio> listaServicios = new ArrayList<>();
    
    //Constructor
    public Servicio(String tipo, float duracion, float precio, boolean estado) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.precio = precio;
        this.estado = estado;
    }
    
    //Getters
    public String getTipo() {
        return tipo;
    }

    public float getDuracion() {
        return duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public boolean isEstado() {
        return estado;
    }
    
    //Setters
    public void setTipo(String tipo) {
        this.tipo = (tipo);
    }

    public void setDuracion(float duracion) {
        this.duracion = (duracion);
    }

    public void setPrecio(float precio) {
        this.precio = (precio);
    }

    public void setEstado(boolean estado) {
        this.estado = (estado);
    }
    
    //Metodos
    
    @Override
    public String toString(){
        return this.getTipo();
    }
    
    public static ArrayList<Servicio> cargarServicios(String ruta){
        ArrayList<Servicio> lista = new ArrayList<>();
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(ruta))){
            lista = (ArrayList<Servicio>)input.readObject();
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
