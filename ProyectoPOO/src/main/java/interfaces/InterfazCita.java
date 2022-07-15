/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import clases.Cita;
import clases.Servicio;
import clases.personas.Cliente;
import clases.personas.Empleado;
import java.util.ArrayList;
import java.util.Date;
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
        while(opcion!=4){
            
            System.out.println("\tCitas");
            
            System.out.println("Que desea realizar: ");
            System.out.println("1. Crear una Cita");
            System.out.println("2. Eliminar una Cita");
            System.out.println("3. Consultar una Cita");
            System.out.println("4. Regresar");
            
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> crearCita();
                case 2 -> eliminarCita();
                case 3 -> consultarCitas();
                case 4 -> System.out.println("");
                default -> System.out.println("Opcion Invalida");
            }
        }
    }
    
    public void crearCita(){
        System.out.println("\tCrear Cita");
        
        //Ingreso de Cliente
        System.out.println("Seleccion de Cliente.");
        InterfazCliente.mostrarClientes();
        System.out.print("Seleccione un cliente: ");
        int seleccion = sc.nextInt();
        sc.nextLine();
        Cliente cl = Cliente.listaClientes.get(seleccion-1);
        
        //Ingreso del Servicio
        System.out.println("Seleccion de Servicio");
        InterfazServicio.mostrarServicios();
        System.out.print("Seleccione el servicio: ");
        seleccion = sc.nextInt();
        sc.nextLine();
        Servicio ser = Servicio.listaServicios.get(seleccion-1);
        
        //Ingreso de empleado
        System.out.println("Seleccion de Empleados.");
        InterfazEmpleado.mostrarEmpleados();
        System.out.print("Seleccione el empleado: ");
        seleccion = sc.nextInt();
        sc.nextLine();
        Empleado emp = Empleado.listaEmpleados.get(seleccion-1);
        
        //Ingreso de la fecha.
        System.out.println("Digite la fecha de la cita: ");
        System.out.print("Digite el anio de la nueva cita: ");
        int anio = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Digite el mes: ");
        String mes = sc.nextLine();
        
        System.out.print("Digite el dia: ");
        int dia = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Digite la hora: ");
        int hora = sc.nextInt();
        System.out.print("Digite los minutos: ");
        int min = sc.nextInt();
        
        if(InterfazAtencion.validarFecha(mes, dia, anio) && 0<=hora && hora<24 && 0<=min && min<=60){
            int indiceMes = InterfazAtencion.buscarMes(mes);
            Date fecha = new Date(anio-1900, indiceMes, dia, hora, min);
            for(int i=0; i<Cita.listaCitas.size();i++){
                Cita cita = Cita.listaCitas.get(i);
                
                if(!cita.getFecha().equals(fecha) || !cita.getEmpleado().equals(emp) ){
                    Cita nCita = new Cita(fecha, cl, emp, ser);
                    Cita.listaCitas.add(nCita);
                    System.out.println("Se ha creado la cita correctamente");
                    i = Cita.listaCitas.size();
                }
            }
        }
        
        else{
            System.out.println("Datos Incorrectos.");
        }
        
    }   
    
    public void eliminarCita(){
        System.out.println("\tEliminar una Cita");
        System.out.print("Ingrese la cedula de un cliente: ");
        String cedula = sc.nextLine();
        
        ArrayList<Cita> citasFiltradas = filtrarCitas(cedula);
        
        if(citasFiltradas.isEmpty()){
            System.out.println("Citas no Encontradas");
        }
        
        else{
            System.out.print("Seleccione que cita desea eliminar: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            
            if(opcion <= citasFiltradas.size() && 0<=opcion){
                int indice = Cita.listaCitas.indexOf(citasFiltradas.get(opcion-1));
                
                Cita.listaCitas.get(indice).setEstado(false);
                System.out.println("Se ha eliminado correctamente");
            }
            else{
                System.out.println("Opcion invalida");
            }
        }
        
    }
    
    //Metodo para consultar las citas
    public void consultarCitas(){
        System.out.println("\tConsultar Citas");
        System.out.println("Ingrese una fecha a buscar: ");
        //Recoge el anio
        System.out.print("Ingrese el año: ");
        int anio = sc.nextInt();
        sc.nextLine();
        //Recoge el mes
        System.out.print("Ingrese el mes: ");
        String mes = sc.nextLine();
        
        //Recoge el dia
        System.out.print("Ingrese el dia: ");
        int dia = sc.nextInt();
        sc.nextLine();
        
        if(InterfazAtencion.validarFecha(mes, dia, anio)){
            int contador = 0;
            for(Cita c: Cita.listaCitas){
                Date fecha = c.getFecha();
                if(fecha.getYear() == anio-1900 && fecha.getMonth() == InterfazAtencion.buscarMes(mes) && fecha.getDate() == dia && c.isEstado()){
                    contador++;
                    System.out.println((Cita.listaCitas.indexOf(c)+1) + ". " + c.toString());
                }
            }
        }
        
    }
    
    //Filtra las citas de la cedula ingresada y retorna un arraylist con ellas.
    public ArrayList<Cita> filtrarCitas(String cedula){
        int contador = 0;
        ArrayList<Cita> citasFiltradas = new ArrayList<>();
        System.out.println("Citas de: " + cedula);
        for(Cita c: Cita.listaCitas){
            Cliente cl = c.getCliente();
            
            if(cedula.equals(cl.getCedula())){
                contador +=1;
                System.out.println(contador + ". " + c.toString());
                citasFiltradas.add(c);
                
            }
           
        }
        return citasFiltradas;
    }
    
    

}
