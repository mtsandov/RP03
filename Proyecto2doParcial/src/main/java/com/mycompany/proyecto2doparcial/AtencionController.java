/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Angello Bravo
 */
public class AtencionController {
    @FXML
    private void cambiarRegistrar() throws IOException{
        App.setRoot("registrarAtencion");
    }
    
    @FXML
    private void cambiarConsultar() throws IOException{
        App.setRoot("consultarAtencion");
    }
    
    @FXML
    private void regresar() throws IOException{
        App.setRoot("atenciones");
    }
    @FXML
    private void cambiarMain() throws IOException{
        App.setRoot("main");
    }
}
