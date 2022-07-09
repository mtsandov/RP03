/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import clases.personas.Empleado;
import java.util.Scanner;

/**
 *
 * @author Angello Bravo
 */
public class InterfazEmpleado {
    Scanner sc = new Scanner(System.in);
    
    //Interfaz Principal de los Empleados
    public void mostrarInterfazEmpleado(){
        int opcion = 0;
        while(opcion != 4){
            
            //Muestra a todos los empleados activos
            System.out.println("\tEmpleados");
            for(Empleado emp: Empleado.listaEmpleados){
                if(emp.isEstado()){
                    System.out.println((Empleado.listaEmpleados.indexOf(emp)+1) + ". " + emp.toString());
                }
            }
            
            System.out.println("\nQue desea realizar: ");
            System.out.println("1. Agregar un nuevo Empleado");
            System.out.println("2. Editar a un Empleado");
            System.out.println("3. Eliminar a un Empleado");
            System.out.println("4. Regresar");
            System.out.print("\nSelecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> agregarEmpleado();
                case 2 ->                     {
                        System.out.println("Editar a un Empleado");
                        System.out.print("Seleccione al Empleado que quiere editar: ");
                        int empleado = sc.nextInt();
                        if(empleado <= Empleado.listaEmpleados.size()){
                            editarEmpleado(Empleado.listaEmpleados.get(empleado-1));
                        }
                        else{
                            System.out.println("Empleado no encontrado");
                        }                          }
                case 3 ->                     {
                        System.out.println("Eliminar a un empleado");
                        System.out.print("Cual empleado desea eliminar?: ");
                        int empleado = sc.nextInt();
                        if(empleado <= Empleado.listaEmpleados.size()){
                            eliminarEmpleado(Empleado.listaEmpleados.get(empleado-1));
                        }
                        
                        else{
                            System.out.println("Empleado no encontrado");
                        }                          }
                default -> {
                }
            }
            
        }
        
          
    }
    
    
    //Metodo AgregarEmpleado
    public void agregarEmpleado(){
        System.out.println("\tAgregar Empleado");
        System.out.print("1. Ingrese la cedula: ");
        String ced = sc.nextLine();
        
        System.out.print("2. Ingrese el nombre completo: ");
        String nombre = sc.nextLine();
        
        System.out.println("3. Ingrese el numero de telef");
        String telef = sc.nextLine();
        
        System.out.println("4. Ingrese el email: ");
        String email = sc.nextLine();
        
        Empleado nuevoEmp = new Empleado(true, ced, nombre, telef, email);
        Empleado.listaEmpleados.add(nuevoEmp);
    }
    
    //Metodo editarEmpleado
    public void editarEmpleado(Empleado emp){
        int opcion = 0;
        while(opcion != 4){
            System.out.println("Editar al empleado: " + emp.getNombre() );
            System.out.println("1. Nombre");
            System.out.println("2. Telefono");
            System.out.println("3. Email");
            System.out.println("4. Regresar");
            
            System.out.print("\nQue desea editar: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nuevo nombre: ");
                    String n = sc.nextLine();
                    emp.setNombre(n);
                }
                case 2 -> {
                    System.out.print("Ingrese el nuevo numero de telefono: ");
                    String t = sc.nextLine();
                    emp.setTelef(t);
                }
                case 3 -> {
                    System.out.println("Ingrese el nuevo email: ");
                    String e = sc.nextLine();
                    emp.setEmail(e);
                }
                default -> System.out.println("Opcion Invalida");
            }
        }
        
    }
    
    //Metodo eliminarEmpleado
    public void eliminarEmpleado(Empleado emp){
        emp.setEstado(false);
    }
}
