/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import clases.Servicio;
import java.util.Scanner;

/**
 *
 * @author Angello Bravo
 */
public class InterfazServicio {
    Scanner sc = new Scanner(System.in);
    
    public static void mostrarServicios(){
        for(Servicio s: Servicio.listaServicios){
            if(s.isEstado()){
                System.out.println((Servicio.listaServicios.indexOf(s)+1) + ". " + s.toString());
            }
        }
    }
    
    public void mostrarInterfazServicio(){
        int opcion = 0;
        
        while(opcion != 4){
            System.out.println("\tServicios");
            mostrarServicios();
            
            System.out.println("\nQue desea realizar: ");
            System.out.println("1. Agregar un nuevo Servicio");
            System.out.println("2. Editar un Servicio");
            System.out.println("3. Eliminar un Servicio");
            System.out.println("4. Regresar");
            
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> agregarServicio();
                case 2 -> {
                    System.out.println("Editar Servicio");
                    System.out.print("Seleccione el Servicio que quiere editar: ");
                    int servicio = sc.nextInt();
                    sc.nextLine();
                    
                    if(servicio <= Servicio.listaServicios.size()){
                        editarServicio(Servicio.listaServicios.get(servicio-1));
                    }
                    else{
                        System.out.println("Servicio no encontrado");
                    }
                }
                case 3 -> {
                    System.out.println("Eliminar Servicio");
                    System.out.print("Seleccione el Servicio que quiere eliminar: ");
                    int servicio = sc.nextInt();
                    sc.nextLine();
                    if(servicio<= Servicio.listaServicios.size() && 1<= Servicio.listaServicios.size()){
                        System.out.println( Servicio.listaServicios.get(servicio-1).getTipo() + " eliminado");
                        eliminarServicio(Servicio.listaServicios.get(servicio-1));
                    }
                    
                    else{
                        System.out.println("Servicio no encontrado.");
                    }
                }
                default -> {
                }
            }
            
            
        }
        
    }
    
    //Metodo agregar Servicio
    public void agregarServicio(){
        System.out.println("\tAgregar Servicio");
        System.out.print("Escriba el tipo de Servicio: ");
        String t = sc.nextLine();
        
        System.out.print("Escriba (en min) cuanto es la duracion del Servicio: ");
        int d = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Ingresar el precio del Servicio: ");
        float p = sc.nextFloat();
        sc.nextLine();
        
        Servicio.listaServicios.add(new Servicio(t, d, p, true));
    }
    
    //Metodo editarServicio 
    public void editarServicio(Servicio s){
        int opcion = 0;
        
        while(opcion !=4){
            System.out.println("Editar Servicio: " + s.getTipo());
            System.out.println("1. Tipo");
            System.out.println("2. Duracion");
            System.out.println("3. Precio");
            System.out.println("4. Regresar");
            
            System.out.print("Seleccione un parametro que quiere editar: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nuevo tipo: ");
                    String t = sc.nextLine();
                    s.setTipo(t);
                }
                case 2 -> {
                    System.out.print("Ingrese la nueva duracion: ");
                    int d = sc.nextInt();
                    sc.nextLine();
                    s.setDuracion(d);
                }
                case 3 -> {
                    System.out.println("Ingrese el nuevo precio: ");
                    float p = sc.nextFloat();
                    sc.nextLine();
                    s.setPrecio(p);
                }
                default -> {
                }
            }
            
        }
        
    }
    
    //Metodo eliminar Servicio
    public void eliminarServicio(Servicio s){
        s.setEstado(false);
    }
}
