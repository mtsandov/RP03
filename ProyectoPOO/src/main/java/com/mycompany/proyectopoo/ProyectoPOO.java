/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectopoo;
import clases.Atencion;
import clases.Cita;
import clases.Servicio;
import clases.personas.Cliente;
import clases.personas.Empleado;
import interfaces.InterfazAtencion;

import interfaces.InterfazCita;
import interfaces.InterfazCliente;
import interfaces.InterfazEmpleado;
import interfaces.InterfazServicio;
import java.util.Calendar;
import java.util.Date;

import java.util.Scanner;
/**
 *
 * @author Angello Bravo
 */
public class ProyectoPOO {
    
    //Metodo InicializarSistema
    public static void inicializarSistema(){
        Empleado emp1 = new Empleado(true, "1104498348", "Angello Bravo", "2687198", "adbravo@espol.edu.ec");
        Empleado.listaEmpleados.add(emp1);
        
        Cliente cl1 = new Cliente("Datos", "1103323899", "Juan Perez", "2688087", "uwu@gmail.com");
        Cliente.listaClientes.add(cl1);
        Cliente cl2 = new Cliente("Datos2", "2303323988", "Jean Pesantes", "2687903", "xd@gmail.com");
        Cliente.listaClientes.add(cl2);
        
        Servicio s1 = new Servicio("Terapia de Lenguaje", 100, 30, true);
        Servicio.listaServicios.add(s1);
        Servicio s2 = new Servicio("Terapia Psicopedagógica", 260, 50, true);
        Servicio.listaServicios.add(s2);
        
        Date diaHoy = Calendar.getInstance().getTime(); //Fecha exacta del momento en que se ejecuto el programa
        
        Cita c1 = new Cita(diaHoy, cl1, emp1, s1);
        Cita.listaCitas.add(c1);
        Cita c2 = new Cita(diaHoy, cl2, emp1, s2);
        Cita.listaCitas.add(c2);
        
        Cita citaAtencion = new Cita(new Date(122, 0, 10, 10, 30, 0), cl1, emp1, s1);
        Atencion at = new Atencion(s1, 200, emp1, citaAtencion);
        Atencion.listaAtenciones.add(at);
        
    }
    
    //Metodo que mostrara el menu principa;
    public static void mostrarMenu(){
        System.out.println("\n\tMENU");
        System.out.println("1. Servicios");
        System.out.println("2. Empleados");
        System.out.println("3. Clientes");
        System.out.println("4. Citas");
        System.out.println("5. Atenciones");
        System.out.println("6. Salir");
    }
    

    public static void main(String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in); // Escaner
        int i = 0; //itinerador del ciclo principal
        InterfazCliente iCliente = new InterfazCliente();
        InterfazEmpleado iEmpleado = new InterfazEmpleado();
        InterfazServicio iServicio = new InterfazServicio();
        InterfazCita iCita = new InterfazCita();
        InterfazAtencion iAtencion = new InterfazAtencion();
        
        //Ciclo Principal
        inicializarSistema();
        

        while(i !=6){
            mostrarMenu();
            
            System.out.print("Seleccionar una opcion: ");
            i = sc.nextInt();
            sc.nextLine();
            
            //Condiciones de las secciones
            //Seccion de Servicios
            switch (i) {
                case 1 -> iServicio.mostrarInterfazServicio();
                case 2 -> iEmpleado.mostrarInterfazEmpleado();
                case 3 -> iCliente.mostrarInterfazClientes();
                case 4 -> iCita.mostrarInterfazCita();
                case 5 -> iAtencion.mostrarInterfazAtencion();
                case 6 -> System.out.println("Usted ha salido del programa");
                default -> System.out.println("Opcion Invalida");
            }
            

    
    }
}
    
}
