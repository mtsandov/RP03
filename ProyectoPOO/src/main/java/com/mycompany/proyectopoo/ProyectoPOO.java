/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectopoo;
import clases.Cita;
import clases.Servicio;
import clases.personas.Cliente;
import clases.personas.Empleado;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Angello Bravo
 */
public class ProyectoPOO {
    
    //Metodo InicializarSistema
    public static void inicializarSistema(){
        Empleado emp1 = new Empleado(true, "1104498347", "Angello Bravo", "2687198", "adbravo@espol.edu.ec");
        Empleado.listaEmpleados.add(emp1);
        
        Cliente cl1 = new Cliente("Datos", "1103323899", "Juan Perez", "2688087", "uwu@gmail.com");
        Cliente.listaClientes.add(cl1);
        Cliente cl2 = new Cliente("Datos2", "2303323988", "Jean Pesantes", "2687903", "xd@gmail.com");
        Cliente.listaClientes.add(cl2);
        
        Servicio s1 = new Servicio("Terapia de Lenguaje", 100, 30, true);
        Servicio.listaServicios.add(s1);
        Servicio s2 = new Servicio("Terapia Psicopedagógica", 260, 50, true);
        Servicio.listaServicios.add(s2);
        
        
        Cita c1 = new Cita(new Date(122, 5, 3), new Time(16, 30, 0), cl1, emp1);
        Cita.listaCitas.add(c1);
        Cita c2 = new Cita(new Date(122, 4, 21), new Time(15, 0, 0), cl2, emp1);
        Cita.listaCitas.add(c2);
        
    }
    
    public static void main(String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in);
        int i = 0; //itinerador del ciclo principal
        
        //Ciclo Principal
        inicializarSistema();
        while(i != 6){
            System.out.println("\n\tMENU");
            System.out.println("1. Servicios");
            System.out.println("2. Empleados");
            System.out.println("3. Clientes");
            System.out.println("4. Citas");
            System.out.println("5. Atenciones");
            System.out.println("6. Salir");
            
            System.out.print("Seleccionar una opcion: ");
            i = sc.nextInt();
            
            //Condiciones de las secciones
            if(i == 1){
                System.out.println("Servicios");
            }
            
            else if(i == 2){
                System.out.println("Empleados");
            }
            
            else if(i == 3){
                System.out.println("Clientes");
            }
            
            else if(i == 4){
                System.out.println("Citas");
            }
            
            else if(i == 5){
                System.out.println("Atenciones");
            }
            
            else if(i == 6){
                System.out.println("Usted ha salido del programa");
            }
            
            else{
                System.out.println("Opcion Invalida");
            }
        }

    
    }
}
