/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.personas.Cliente;
import clases.personas.Empleado;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Angello Bravo
 */
public class Cita {
    //Atributos
    private Date fecha;
    private Time hora;
    private Cliente cliente;
    private Empleado empleado;
    private boolean estado;
    public static ArrayList<Cita> listaCitas = new ArrayList<>();
    
    //Constructor
    public Cita(Date fecha, Time hora, Cliente cliente, Empleado empleado) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.empleado = empleado;
        estado = true;
    }
    
    //Getters
    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public boolean isEstado() {
        return estado;
    }
    
    
    //Setters
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return getCliente().getCedula() + " - " + getCliente().getNombre() + " | " + "Empleado: " + getEmpleado().getNombre() + " - " + getFecha() + " - " + getHora(); 
    }
    
    
    
    
}
