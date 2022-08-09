package com.mycompany.proyecto2doparcial;


import java.io.IOException;
import javafx.fxml.FXML;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Angello Bravo
 */
public class CitaController {
    
    @FXML
    private void cambiarAgregar() throws IOException{
        App.setRoot("agregarCita");
    }
    
    @FXML
    private void cambiarConsultar() throws IOException{
        App.setRoot("consultarCitas");
    }
    
    @FXML
    private void regresar() throws IOException{
        App.setRoot("citas");
    }
    
    @FXML
    private void cambiarMain() throws IOException{
        App.setRoot("main");
    }
}
