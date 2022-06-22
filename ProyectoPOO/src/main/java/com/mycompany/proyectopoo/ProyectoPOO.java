/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectopoo;
import clases.personas.Empleado;
import java.util.Scanner;
/**
 *
 * @author Angello Bravo
 */
public class ProyectoPOO {
    
    public static void main(String[] args) {
        //Variables
        Scanner sc = new Scanner(System.in);
        int i = 0; //itinerador del ciclo principal
        
        //Ciclo Principal
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
