/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.Atencion;
import clases.Cita;
import clases.personas.Empleado;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Angello Bravo
 */
public class RegistrarAtencionController {
    
    //Atributos
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbFecha;
    @FXML
    private TextField duracionReal;
    @FXML
    private ComboBox cbEmpleados;
    
    
    public void llenarCampos(Cita c){
        lbNombre.setText(c.getCliente().getNombre());
        String f = c.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String h = c.getHora().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        lbFecha.setText(f + " " + h);
        cbEmpleados.getItems().setAll(Empleado.cargarEmpleados(App.pathEmpleados));
    }
    
    @FXML
    private void regresar() throws IOException{
        App.setRoot(App.pathFXMLCitas);
    }
    
    //Metodo encargado de cambiar a la pestania de la actividad.
    @FXML
    private void empezarActividad(Atencion at) throws IOException{
        System.out.println("Hola :D");
//        FXMLLoader fxml = new FXMLLoader(App.class.getResource("Actividad/actividad.fxml"));
//        ActividadController ct = new ActividadController();
//        fxml.setController(ct);
//        BorderPane root = (BorderPane)fxml.load();
//        App.changeRoot(root);
    }
}
