/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;
 
import clases.Atencion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Angello Bravo
 */
public class ActividadController implements Initializable{
    
    //Atributos
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbTiempo;
    @FXML
    private Label lbNumero;
    @FXML
    private GridPane cuadricula;
            
    //Atributos no FXML
    int[] arrNumeros = new int[20];
    public static boolean iniciar = true;
    public static int hora=0, min=0, seg=0;
    //Cronometro cronometro = new Cronometro(lbTiempo);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         arrNumeros = generarArreglo(1, 20);
         int aleatorio = (int) (Math.random()*20)+1;
         lbNumero.setText(Integer.toString(aleatorio));
         
         //Llenar de los botones de los numeros aleatorios antes obtenidos.
//         for(int i=0; i<4;i++ ){
//             for(int j=0; j<5; i++){
//                Button bt = (Button)cuadricula.getChildren().get(j);
//                bt.setText("bUNEASS");
//             }
//         }
        
        Reloj rj = new Reloj(lbTiempo);
        rj.setDaemon(true);
        rj.start();
         //Inciar el hilo del cronometro
         //cronometro.setDaemon(true);
         //cronometro.start();
         
    }
    
    //Metodo que generara el arreglo con numeros aleatorios
    public int[] generarArreglo(int min, int max){
        int[] x = new int[20];
        for(int i=0;i<x.length;i++){
            x[i] = (int) (Math.random()*max)+min;
        }
        return x;
    }
    
    public void llenarEspacios(Atencion t){
        lbNombre.setText("Paciente: " +t.getCita().getCliente().toString());
        lbTiempo.setText("0:0:0");
        
    }
    
    @FXML
    public void accion() throws IOException{
        System.out.println();
    }
    
    //Clase interna que crera un hilo para el cronometro
    private class Reloj extends Thread{
        @FXML
        Label e;
        Reloj(Label e){
            this.e = e;
        }
        @Override
        public void run(){
            try{
                int x = 0;
                while(iniciar){
                    ejecutarReloj(x);
                    Thread.sleep(1000);
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
        public void ejecutarReloj(int x){
            seg++;
            if(seg >59){
                seg =0;
                min++;
            }
            if(min>59){
                seg=0;
                min=0;
                hora++;
            }
            
            System.out.println(hora + ":" + min + ":" + seg);
            e.setText(hora +":" + min + ":" + seg);
        }
        
    }
    
    
    
    
    
    
}
