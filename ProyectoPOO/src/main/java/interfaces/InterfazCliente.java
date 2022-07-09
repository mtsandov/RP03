/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import clases.personas.Cliente;
import java.util.Scanner;

/**
 *
 * @author Angello Bravo
 */
public class InterfazCliente {
    Scanner sc = new Scanner(System.in);
    
    public void mostrarInterfazClientes(){
        int opcion = 0;
        
        while(opcion != 3){
            
            //Lista de CLientes
            System.out.println("\tClientes:");
            for(Cliente cl: Cliente.listaClientes){
                System.out.println((Cliente.listaClientes.indexOf(cl)+1) + ". " + cl.toString());
            }
            
            System.out.println("\nQue desea realizar:");
            System.out.println("1. Agregar un nuevo cliente.");
            System.out.println("2. Editar un Cliente");
            System.out.println("3. Regresar");
            
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            if(opcion == 1){
                agregarCliente();
            }
            
            else if(opcion == 2){
                System.out.println("Editar un Cliente");
                System.out.print("Seleccione el cliente que desea editar: ");
                int seleccion = sc.nextInt();
                sc.nextLine();
                
                if(seleccion <= Cliente.listaClientes.size()){
                    editarCliente(Cliente.listaClientes.get(seleccion-1));
                }
                
                else{
                    System.out.println("Seleccion no valida");
                }
            }
            
        }    
    }
    
    //Metodo Agregar Cliente
    public void agregarCliente(){
        System.out.println("\tAgregar Cliente");
        System.out.print("Digite su cedula: ");
        String ced = sc.nextLine();
        
        System.out.print("Digite su nombre completo: ");
        String nombre = sc.nextLine();
        
        System.out.print("Digite su numero de telef: ");
        String telef = sc.nextLine();
        
        System.out.print("Digite su email: ");
        String email = sc.nextLine();
        
        System.out.print("Digite los datos del representante: ");
        String datos = sc.nextLine();
        
        Cliente nuevoCl = new Cliente(datos, ced, nombre, telef, email);
        Cliente.listaClientes.add(nuevoCl);
    }
    
    public void editarCliente(Cliente cl){
        int i = 0;
        while(i != 5){
            System.out.println("Editar al Cliente: " + cl.getNombre());
            System.out.println("1. Nombre");
            System.out.println("2. Telefono");
            System.out.println("3. E-mail" );
            System.out.println("4. Datos del Representante");
            System.out.println("5. Regresar");
            
            System.out.print("\nSeleccione un parametro que desea editar: ");
            i = sc.nextInt();
            sc.nextLine();
            
            //Cambiar Nombre
            switch (i) {
                case 1 -> {
                    System.out.println("\tNombre");
                    System.out.print("Digite el nuevo nombre: ");
                    String n = sc.nextLine();
                    cl.setNombre(n);
                    System.out.println("Se ha registrado el nuevo nombre.");
                }
                case 2 -> {
                    System.out.println("\tTelefono");
                    System.out.print("Digite el nuevo numero de telefono: ");
                    String t = sc.nextLine();
                    cl.setTelef(t);
                    System.out.println("Se ha registrado el telefono.");
                }
                case 3 -> {
                    System.out.println("\tE-mail");
                    System.out.print("Ingrese el nuevo email: ");
                    String e = sc.nextLine();
                    cl.setEmail(e);
                    System.out.println("Se ha registrado el nuevo email.");
                }
                case 4 -> {
                    System.out.println("\tDatos del Representante");
                    System.out.print("Ingrese los nuevos Datos del Representante");
                    String d = sc.nextLine();
                    cl.setDatos(d);
                    System.out.println("Se han registrado los nuevos datos.");
                }
                default -> System.out.println("Opcion Invalida");
            }
            
        }
        
    }
    
}
