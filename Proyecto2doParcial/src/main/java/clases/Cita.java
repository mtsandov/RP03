/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.personas.Cliente;
import clases.personas.Empleado;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Angello Bravo
 */
public class Cita {
    //Atributos
    private Date fecha; //Dentro del objeto ya viene incluida la hora.
    private Cliente cliente;
    private Servicio servicio;
    private Empleado empleado;
    private boolean estado;
    public static ArrayList<Cita> listaCitas = new ArrayList<>();
    
    //Constructor
    public Cita(Date fecha, Cliente cliente, Empleado empleado, Servicio servicio) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        estado = true;
    }
    
    //Getters
    public Date getFecha() {
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
    

    public boolean isEstado() {
        return estado;
    }
    
    
    //Setters
    public void setFecha(Date fecha) {
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
    

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return getCliente().getCedula() + " - " + getCliente().getNombre() + " - " + getServicio().getTipo() + " | " + "Empleado: " + getEmpleado().getNombre() + " - " + getFecha(); 
    }
    
    
    
    
}
