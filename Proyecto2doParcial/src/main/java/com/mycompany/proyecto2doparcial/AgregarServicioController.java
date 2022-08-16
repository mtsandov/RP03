/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.Servicio;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author Angello Bravo
 */
public class AgregarServicioController implements Initializable, Serializable{
    
    //Atributos
    @FXML 
    private TextField txtTipo;
    @FXML
    private TextField txtDuracion;
    @FXML
    private TextField txtPrecio;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(""); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @FXML
    private void regresar() throws IOException{
        App.setRoot(App.pathFXMLEmpleados);
    }
    
    @FXML
    private void guardarServicio(){
        ArrayList<Servicio> listaServicios = Servicio.cargarServicios(App.pathServicios);
        Servicio ser = new Servicio(txtTipo.getText(), Float.parseFloat(txtDuracion.getText()), Float.parseFloat(txtPrecio.getText()), true);
        listaServicios.add(ser);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.pathServicios))){
        //Serializacion
            out.writeObject(listaServicios);
            out.flush();
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Information Dialog");
            alerta.setHeaderText("Resultado de la operación");
            alerta.setContentText("Servicio: " + txtTipo.getText() +  " agregada exitosamente");
            alerta.showAndWait();
            
            App.setRoot(App.pathFXMLServicios);
            
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setContentText("Error al registrar el nuevo servicio");
            alerta.showAndWait();
        }
    }
    
}
