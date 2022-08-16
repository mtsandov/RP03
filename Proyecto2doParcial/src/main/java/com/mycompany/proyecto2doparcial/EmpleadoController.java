/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2doparcial;

import clases.Servicio;
import clases.personas.Empleado;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Angello Bravo
 */
public class EmpleadoController implements Initializable{
    
    //Atributos FXML
    @FXML
    private TableView<Empleado> tablaEmpleados;
    @FXML
    private TableColumn<Empleado, String> colCedula;
    @FXML
    private TableColumn<Empleado, String> colNombre;
    @FXML
    private TableColumn<Empleado, String> colTelef;
    @FXML
    private TableColumn<Empleado, String> colEmail;
    @FXML
    private TableColumn<Empleado, Boolean> colEstado;
    
    //Atributos Java
    public ObservableList<Empleado> lista;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista = FXCollections.observableArrayList();
        ArrayList<Empleado> cargaEmpleados = Empleado.cargarEmpleados(App.pathEmpleados);
        for(Empleado em:cargaEmpleados){
            lista.add(em);
        }
        
        //Crear Tabla
        colEstado.setCellValueFactory(new PropertyValueFactory<Empleado, Boolean>("estado"));
        colCedula.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        colTelef.setCellValueFactory(new PropertyValueFactory<Empleado, String>("telef"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Empleado, String>("email"));
        
        tablaEmpleados.setItems(lista);
        
    }
    
    @FXML
    private void cambiarAgregar() throws IOException{
        App.setRoot("Empleados/agregarEmpleado");
    }
    
    @FXML
    private void cambiarMain() throws IOException{
        App.setRoot("main");
    }
    
}
