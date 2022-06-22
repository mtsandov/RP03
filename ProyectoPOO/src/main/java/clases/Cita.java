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
    public static ArrayList<Cita> listaCitas = new ArrayList<Cita>();
    
    //Constructor
    public Cita(Date fecha, Time hora, Cliente cliente, Empleado empleado) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.empleado = empleado;
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
    
    
    
}
