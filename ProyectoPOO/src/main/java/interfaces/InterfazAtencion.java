/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import clases.Atencion;
import clases.Cita;
import clases.personas.Empleado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Angello Bravo
 */
public class InterfazAtencion {
    //Atributos y Variables.
    Scanner sc = new Scanner(System.in);
    public static String [] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    
    //Interfaz Principal
    public void mostrarInterfazAtencion(){
        int opcion = 0;
        
        while(opcion != 3){
            
            System.out.println("Que desea realizar.");
            System.out.println("1. Registrar Atencion");
            System.out.println("2. Consultar Atencion");
            System.out.println("3. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1 -> registrarAtencion();
                case 2 -> consultarAtencion();
                default -> System.out.println("Opcion Invalida");
            }
            
        }
    }
    
    //Metodo que validara si una fecha ingresada es valida.
    public static boolean validarFecha(String mes, int dia, int anio){
        
        mes = StringUtils.lowerCase(mes);
        
        //Booleanos que nos serviran para manejar el ingreso de dias con respecto a los meses
        boolean diaIgual31 = meses[0].equals(mes) || meses[2].equals(mes) || meses[4].equals(mes) || meses[6].equals(mes) || meses[7].equals(mes) || meses[9].equals(mes) || meses[11].equals(mes);
        boolean diaMenor31 = meses[1].equals(mes) || meses[3].equals(mes) || meses[5].equals(mes) || meses[8].equals(mes) || meses[10].equals(mes);
        
        
        
        return ArrayUtils.contains(meses, mes) && 1<=dia && ((diaIgual31 && dia<=31) || (diaMenor31 && dia<31));
    }
    
    //Metodo que retornara el indice del mes ingresado
    public static int buscarMes(String mes){
        return ArrayUtils.indexOf(meses, mes);
    }
    
    //Metodo para registrar las atenciones
    public void registrarAtencion(){
        System.out.println("\tRegistrar atencion");
        System.out.print("Ingrese un numero de cedula: ");
        String cedula = sc.nextLine();
        
        ArrayList<Cita> citasFiltradas = filtrarCitas(cedula);
        if(!citasFiltradas.isEmpty()){
            for(Cita c: citasFiltradas){
                System.out.println((citasFiltradas.indexOf(c)+1) + ". " + c.toString());
            }
            
            //Selecciona la cita
            System.out.print("Seleccione la cita para la atencion: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            Cita c = citasFiltradas.get(opcion-1);
            
            //Ingresa la duracion de la cita
            System.out.print("Ingrese en minutos la duracion de la cita: ");
            int duracion = sc.nextInt();
            sc.nextLine();
            
            //Selecciona el Empleado que llevo a cabo la cita
            System.out.println("\tEmpleados");
            InterfazEmpleado.mostrarEmpleados();
            System.out.print("Seleccione el empleado que llevo la atencion: ");
            int empleado = sc.nextInt();
            sc.nextLine();
            
            Atencion at = new Atencion(citasFiltradas.get(opcion-1).getServicio(), duracion, Empleado.listaEmpleados.get(empleado-1), citasFiltradas.get(opcion-1));
            Atencion.listaAtenciones.add(at);
            
            //Elimina la cita de la lista de citas pendientes
            int indice = Cita.listaCitas.indexOf(c);
            Cita.listaCitas.get(indice).setEstado(false);
        }
        
        else{
            System.out.println("No existen citas pendientes hoy");
        }
    }
    
    //Filtrar las citas con respecto a la cedula y al dia de hoy
    public ArrayList<Cita> filtrarCitas(String cedula){
        Date fechaHoy = Calendar.getInstance().getTime();
        ArrayList<Cita> citasFiltradas = new ArrayList<>();
        for(Cita c: Cita.listaCitas){
            
            if(c.getCliente().getCedula().equals(cedula) && c.getFecha().getDate() == (fechaHoy.getDate()) && c.getFecha().getMonth() == fechaHoy.getMonth() && c.isEstado()){
                citasFiltradas.add(c);
            }
        }
        
        return citasFiltradas;
    }
    
    //Metodo para consultar Atenciones
    public void consultarAtencion(){
        int opcion = 0;
        while(opcion != 4){
            System.out.println("\tConsultar Atenciones.");
            System.out.println("1. Buscar por Cliente");
            System.out.println("2. Buscar por Empleado");
            System.out.println("3. Buscar por Fecha");
            System.out.println("4. Regresar");

            System.out.print("Que desea hacer: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            //Cedula cliente
            if(opcion == 1){
                System.out.print("Escriba la cedula de algun cliente: ");
                String cedula = sc.nextLine();
                int indice = 0;
                
                for(Atencion at: Atencion.listaAtenciones){
                    if(at.getCita().getCliente().getCedula().equals(cedula)){
                        indice++;
                        System.out.println(indice + ". " + at.toString());
                    }
                }
            }
            
            //Cedula Empleado
            else if(opcion == 2){
                System.out.print("Escriba la cedula de algun empleado: ");
                String cedula = sc.nextLine();
                int indice = 0;
                
                for(Atencion at: Atencion.listaAtenciones){
                    if(at.getEmp().getCedula().equals(cedula)){
                        indice++;
                        System.out.println(indice +". " + at.toString());
                    }
                }
            }
            
            //Se pedira una fecha para la consulta
            else if(opcion == 3){
                System.out.println("Escriba la fecha");
                System.out.print("Escriba el año: ");
                int anio = sc.nextInt();
                sc.nextLine();
                
                System.out.print("Ingrese el mes: ");
                String mes = sc.nextLine();
                
                
                
                System.out.print("Ingrese el dia: ");
                int dia = sc.nextInt();
                sc.nextLine();
                
            
                //Iteracion y comparacion para la creacion de la consulta
                if(validarFecha(mes, dia, anio)){
                    int indice = buscarMes(mes);
                    int contador = 0;
                    
                    System.out.println("\tLista de Consultas");
                    for(Atencion f: Atencion.listaAtenciones){
                        Date fechaAtencion = f.getCita().getFecha();
                        if(fechaAtencion.getYear() == anio-1900 && fechaAtencion.getMonth() == indice && fechaAtencion.getDate() == dia){
                            contador++;
                            System.out.println( contador + ". " + f.toString());
                        }
                    }
                }
                
                else{
                    System.out.println("Datos Incorrectos");
                }
                
            }
            
            else{
                System.out.println("Opcion Invalida");
            }
        }
    }
    
    
    
    
}
