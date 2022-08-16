/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.personas.Cliente;
import clases.personas.Empleado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Angello Bravo
 */
public class Cita implements Serializable{
    //Atributos
    private LocalDate fecha;
    private Cliente cliente;
    private Servicio servicio;
    private Empleado empleado;
    private LocalTime hora;
    private boolean estado;
    public static ArrayList<Cita> listaCitas = new ArrayList<>();
    
    //Constructor
    public Cita(LocalDate fecha, LocalTime hora, Cliente cliente, Empleado empleado, Servicio servicio) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        this.hora = hora;
        estado = true;
    }
    
    //Getters
    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public LocalTime getHora() {
        return hora;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
    //Setters
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }    

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return getCliente().getCedula() + " - " + getCliente().getNombre() + " - " + getServicio().getTipo() + " | " + "Empleado: " + getEmpleado().getNombre() + " - " + getFecha(); 
    }
    

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cita other = (Cita) obj;
        if (!(Objects.equals(this.fecha, other.fecha)) && !(Objects.equals(this.hora, other.hora))) {
            return false;
        }
        return true;
    }
    
    public static ArrayList<Cita> cargarCitas(String ruta){
        ArrayList<Cita> listaCitas = new ArrayList<>();
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(ruta))){
            listaCitas = (ArrayList<Cita>)input.readObject();
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
     
        
        return listaCitas;
    }
    
    
    
}
