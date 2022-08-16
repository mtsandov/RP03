/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.personas.Empleado;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
public class AgregarEmpleadoController implements Initializable{
    
    //Atributos
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelef;
    @FXML
    private TextField txtEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(""); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Metodos
    @FXML
    private void regresar() throws IOException{
        App.setRoot(App.pathFXMLEmpleados);
    }
    
    @FXML
    private void guardarEmpleado(){
        ArrayList<Empleado> listaEmpleados = Empleado.cargarEmpleados(App.pathEmpleados);
        Empleado emp = new Empleado(true, txtCedula.getText(), txtNombre.getText(), txtTelef.getText(), txtEmail.getText());
        listaEmpleados.add(emp);
        
        //Serializacion
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(App.pathEmpleados))){
            out.writeObject(listaEmpleados);
            out.flush();
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Information Dialog");
            alerta.setHeaderText("Resultado de la operación");
            alerta.setContentText("Persona: " + txtNombre.getText() + " agregada exitosamente");
            alerta.showAndWait();
            
            App.setRoot(App.pathFXMLEmpleados);
            
        }
        catch(IOException e){
            //System.out.println(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
