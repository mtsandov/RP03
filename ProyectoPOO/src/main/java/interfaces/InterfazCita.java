/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import clases.Cita;
import clases.personas.Cliente;
import java.util.Scanner;

/**
 *
 * @author Angello Bravo
 */
public class InterfazCita {
    Scanner sc = new Scanner(System.in);
    
    //Interfaz principal de las Citas
    public void mostrarInterfazCita(){
        int opcion = 0;
        while(opcion != 4){
            
            System.out.println("\tCitas");
            
            System.out.println("\nQue desea realizar: ");
            System.out.println("1. Crear una Cita");
            System.out.println("2. Eliminar una Cita");
            System.out.println("3. Consultar una Cita");
            System.out.println("4. Regresar");
            
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            if(opcion == 1){
                System.out.println("Crear Cita");
            }
            
            else if(opcion == 2){
                eliminarCita();
            }
            
            else if(opcion == 3){
                System.out.println("Consultar una cita");
            }
            
            else{
                System.out.println("Opcion Invalida");
            }
             
        }
    }
    
    public void crearCita(){ //Falta COmpletar
        System.out.println("\tCrear Cita");
        
        System.out.println("Digite la fecha de la cita: ");
        System.out.print("Digite el mes: ");
        int mes = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Digite el dia: ");
        int dia = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Digite la hora: ");
        int hora = sc.nextInt();
        System.out.println("Digite los minutos");
        int min = sc.nextInt();
        
        
    }   
    
    public void eliminarCita(){
        System.out.println("\tEliminar una Cita");
        System.out.print("Ingrese la cedula de un cliente: ");
        String cedula = sc.nextLine();
        
        int contador = visualizarCitaPorCedula(cedula);
        System.out.print("Seleccione que cita desea eliminar: ");
        int opcion = sc.nextInt();
        
        if(opcion <= contador){ //Falta completar esta funcion
           
            
        }
    }
    
    //Metodo visualizarCitasPorCedula es para filtrar las citas por cedula
    public int visualizarCitaPorCedula(String cedula){
        int contador = 0;
        
        for(Cita c: Cita.listaCitas){
            Cliente cl = c.getCliente();
            
            if(cedula.equals(cl.getCedula())){
                contador +=1;
                System.out.println("Citas de " + cl.getNombre());
                System.out.println(contador + ". " + c.toString());
            }
           
        }
        return contador;
    }
    
}
