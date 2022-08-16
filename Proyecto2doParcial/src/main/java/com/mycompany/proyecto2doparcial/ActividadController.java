/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
            
            
    int[] arrNumeros = new int[20];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         System.out.println("arrNumeros");;
    }
    
    //Metodo que generara el arreglo con numeros aleatorios
    public int[] generarArreglo(){
        int[] x = new int[20];
        for(int i=0;i<x.length;i++){
            x[i] = (int) (Math.random()*20)+1;
        }
        return x;
    }
    
    
    
    
}
