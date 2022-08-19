/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.mycompany.proyecto2doparcial.ActividadController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author Angello Bravo
 */
public class Cronometro extends Thread{
    
    @FXML
    Label e;

    public Cronometro(Label e) {
        this.e = e;
    }
    
    
    
    @Override
    public void run(){
        try{
            int x =0;
            
            while(ActividadController.iniciar){
                Thread.sleep(1000);
                ejecutarCronometro(x);
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void ejecutarCronometro(int x){
        ActividadController.seg += 1;
        if(ActividadController.seg >59){
            ActividadController.seg = 0;
            ActividadController.min++;
        }
        if(ActividadController.min >59){
            ActividadController.seg = 0;
            ActividadController.min = 0;
            ActividadController.hora++;
        }
        
        
        System.out.println(ActividadController.hora +":" + ActividadController.min + ":" + ActividadController.seg);
        //textCronometro = ActividadController.hora +":" + ActividadController.min + ":" + ActividadController.seg;
        e.setText(ActividadController.hora +":" + ActividadController.min + ":" + ActividadController.seg);
        
    }
    
    
}
